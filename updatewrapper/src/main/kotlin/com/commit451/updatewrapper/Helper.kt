package com.commit451.updatewrapper

import org.gradle.internal.os.OperatingSystem

/**
 * Helps with things
 */
internal object Helper {

    const val COMMAND_VERSION = "./gradlew --version"
    const val COMMAND_UPDATE = "./gradlew wrapper --gradle-version {version}"


    fun getCurrentVersion(): String {
        val command = if (windows()) COMMAND_VERSION.replace("./gradlew", "gradlew") else COMMAND_VERSION
        val output = runCommandForOutput(command)
        return getVersionFromVersionOutput(output)
    }

    fun runCommandForOutput(command: String): String {
        return runCommand(command).inputStream.convertToString()
    }

    fun runCommand(command: String): Process {
        val process = Runtime.getRuntime().exec(command)
        process.waitFor()
        return process
    }

    fun runUpdateCommand(releaseName: String): Int {
        var command = COMMAND_UPDATE.replace("{version}", releaseName)
        if (windows()) {
            command = command.replace("./gradlew", "gradlew")
        }
        val process = runCommand(command)
        return process.exitValue()
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