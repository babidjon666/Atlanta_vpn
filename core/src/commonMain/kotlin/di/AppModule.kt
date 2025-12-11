package di

import domain.entity.Api.InsultCensorClient

import io.ktor.client.*
import org.kodein.di.*

val AppModule = DI.Module("AppModule") {
    bind<HttpClient>() with singleton { error("HttpClient not initialized") }
    bind<InsultCensorClient>() with singleton { InsultCensorClient(instance()) }
}