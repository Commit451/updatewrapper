package com.commit451.updatewrapper

import com.google.common.io.Resources
import java.io.IOException



/**
 * Helper for test things
 */
object Tester {

    @Throws(IOException::class)
    fun getFileText(fileName: String): String {
        val url = Resources.getResource(fileName)
        return Resources.toString(url, Charsets.UTF_8)
    }
}