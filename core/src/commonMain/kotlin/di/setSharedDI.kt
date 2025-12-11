package di

import org.kodein.di.DI

lateinit var sharedDI: DI
    private set

fun setSharedDI(di: DI) {
    sharedDI = di
}