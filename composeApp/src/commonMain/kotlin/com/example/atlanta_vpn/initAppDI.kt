package com.example.atlanta_vpn

import di.setSharedDI
import di.AppModule
import io.ktor.client.HttpClient
import org.kodein.di.*

fun initAppDI(httpClient: HttpClient) {
    val di = DI {
        import(AppModule)

        bind<HttpClient>(overrides = true) with singleton { httpClient }
    }

    setSharedDI(di)
}