package utills

import android.content.Context
import android.provider.Settings

lateinit var appContext: Context

fun initHWID(context: Context){
    appContext = context.applicationContext
}

actual fun getHWID(): String {
    return Settings.Secure.getString(appContext.contentResolver, Settings.Secure.ANDROID_ID)
}