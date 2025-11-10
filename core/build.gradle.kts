plugins {
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.kotlinSerialization)
}

compose.resources {
    publicResClass = true
    packageOfResClass = "atlanta_vpn.composeapp.generated.resources"
    generateResClass = auto
}

kotlin {
    androidLibrary {
        namespace = "com.example.core"
        compileSdk = 36
        minSdk = 24

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    val xcfName = "coreKit"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
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
                // Room
                api(libs.androidx.room.runtime)
                api(libs.sqlite.bundled)
                api(libs.sqlite)

                // Compose навигация
                implementation(libs.compose.navigation)

                // Анимации JSON
                implementation(libs.compottie)
                implementation(libs.compottie.resources)
                implementation(libs.compottie.dot)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
            }
        }

        iosMain {
            dependencies {
            }
        }
    }
}
afterEvaluate {
    extensions.findByName("android")?.let { ext ->
        (ext as com.android.build.gradle.LibraryExtension).apply {
            sourceSets.getByName("main").assets.srcDir("src/commonMain/composeResources")
        }
    }
}
