package org.futo.inputmethod.engine.general

import java.io.File

/**
 * The schemas [ChineseIME] generates into RIME's user directory, as opposed to the ones that come
 * with the Chinese dictionary download.
 */
internal object ChineseGeneratedSchemas {
    private val SchemaIds = listOf(ChineseZhuyin.SchemaId, ChineseBoshiamy.SchemaId)

    /** Only touches the file if its content changed, as RIME rebuilds what depends on it */
    fun writeIfChanged(file: File, content: ByteArray) {
        if(!file.exists() || !file.readBytes().contentEquals(content)) {
            file.writeBytes(content)
        }
    }

    /**
     * Lists the generated schemas present in [userDir] for deployment, as only listed schemas get
     * deployed. To be called after writing a schema's files.
     */
    fun updateSchemaList(userDir: File) {
        val content = buildString {
            appendLine("patch:")
            appendLine("    schema_list/+:")
            SchemaIds.filter { File(userDir, "$it.schema.yaml").isFile }.forEach {
                appendLine("        - schema: $it")
            }
        }

        writeIfChanged(File(userDir, "default.custom.yaml"), content.toByteArray())
    }
}
