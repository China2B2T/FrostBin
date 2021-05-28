package dev.binclub.paperbin.native

import dev.binclub.paperbin.PaperBinClassTransformer
import dev.binclub.paperbin.native.NativeAccessor.OS.*
import java.io.File
import java.lang.reflect.Method


/**
 * @author cookiedragon234 22/Sep/2020
 */
object NativeAccessor {
    enum class OS {
        WINDOWS,
        LINUX,
        MAC;

        companion object {
            private val os: String = System.getProperty("os.name")
            fun get(): OS = when {
                os.contains("windows", true) -> WINDOWS
                os.contains("linux", true) -> LINUX
                os.contains("mac", true) -> MAC
                else -> error("Unsupported OS $os")
            }
        }
    }


    external fun registerClassLoadHook(hook: PaperBinClassTransformer)
    external fun appendToClassloader(
        url: String,
        bootloader: Boolean = false // System/Bootloader
    )
    external fun registerAntiPhysicsCrash(method: Method, maxStackSize: Int)
}