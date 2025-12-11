import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import kotlin.collections.plus
import org.jetbrains.compose.resources.ResourcesExtension.ResourceClassGeneration.Auto

plugins {
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
}

compose.resources {
    publicResClass = true
    packageOfResClass = "atlanta_vpn.composeapp.generated.resources"
    generateResClass = Auto
}


kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            export(project(":core"))
            export(project(":feature"))
            freeCompilerArgs += "-Xbinary=bundleId=com.example.atlanta_vpn"
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlin.stdlib)

                // Корутины
                api(libs.kotlin.coroutines.core)

                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(compose.material3)
                api(compose.materialIconsExtended)
                api(compose.ui)
                api(compose.components.resources)
                api(compose.animationGraphics)
                api("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.9.6")
                api(project(":data"))
                // Room
                api(libs.androidx.room.runtime)
                api(libs.sqlite.bundled)
                api(libs.sqlite)

                implementation(libs.multiplatform.settings)
                // Compose навигация
                implementation(libs.compose.navigation)
                // DI
                api(libs.kodein)
                // работа с сетью
                implementation(libs.bundles.ktor)
                // Анимации JSON
                implementation(libs.compottie)
                implementation(libs.compottie.resources)
                implementation(libs.compottie.dot)
            }
        }

        androidMain {
            dependencies {
            }
        }

        iosMain {
            dependencies {
            }
        }
    }
}

android {
    namespace = "com.example.atlanta_vpn.core"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

//afterEvaluate {
//    extensions.findByName("android")?.let { ext ->
//        (ext as com.android.build.gradle.LibraryExtension).apply {
//            sourceSets.getByName("main").assets.srcDir("src/commonMain/composeResources")
//        }
//    }
//}
