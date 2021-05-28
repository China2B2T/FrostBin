package dev.binclub.paperbin

interface PaperBinClassTransformer {
    fun onClassLoad(
        clazz: Class<*>?,
        loader: ClassLoader?,
        className: String?,
        classfileBuffer: ByteArray
    ): ByteArray?

    fun onClassPrepare(
        clazz: Class<*>
    )
}