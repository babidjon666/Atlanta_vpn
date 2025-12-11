package utills

import platform.Foundation.NSUUID
import platform.UIKit.UIDevice

actual fun getHWID(): String {
    val idForVendor = UIDevice.currentDevice.identifierForVendor?.UUIDString
    return idForVendor ?: NSUUID().UUIDString()
}
