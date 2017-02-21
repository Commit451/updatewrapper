package com.commit451.updatewrapper

import org.gradle.internal.os.OperatingSystem

/**
 * Helps with things
 */
internal object Helper {

    const val COMMAND_VERSION = "./gradlew --version"

    fun getCurrentVersion(): String {
        val output = runCommandForOutput(COMMAND_VERSION)
        return getVersionFromVersionOutput(output)
    }

    fun runCommandForOutput(command: String): String {
        val builder = ProcessBuilder(command)
                .inheritIO()
                .redirectOutput(ProcessBuilder.Redirect.PIPE)
        val process = builder.start()

        process.waitFor()

        val value = process.inputStream.convertToString()
        return value
    }

    fun getVersionFromVersionOutput(text: String): String {
        val key = "Gradle "
        val startIndex = text.indexOf(key)
        val endIndex = text.indexOf("\n", startIndex)
        return text.substring(startIndex + key.length, endIndex)
    }


    fun windows(): Boolean {
        return OperatingSystem.current().isWindows
    }
}