package com.commit451.updatewrapper

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

/**
 * The task that actually converts things
 */
open class UpdateWrapperTask : DefaultTask() {

    companion object {
        const val COMMAND = "./gradlew wrapper --gradle-version {version}"
    }

    init {
        description = "Updates gradle wrapper to latest version"
        group = "Help"
    }

    @Input
    var windows = false

    @TaskAction
    fun updatewrapper() {
        val gitHub = GitHubFactory.create()
        val releaseResponse = gitHub.getLatestRelease("gradle", "gradle").execute()
        if (releaseResponse.isSuccessful) {
            val releaseName = releaseResponse.body().name
            System.out.println("Updating wrapper to version $releaseName")
            var command = COMMAND.replace("{version}", releaseName)
            if (windows()) {
                command = command.replace("./gradlew", "gradlew")
            }
            val process = Runtime.getRuntime().exec(command)
            process.waitFor()
            if (process.exitValue() == 0) {
                System.out.println("Updated gradle wrapper successfully to version $releaseName")
            } else {
                System.out.println("Unable to run gradle command")
            }
        } else {
            System.out.println("Unable to get latest gradle version to update to")
        }
    }

    fun windows(): Boolean {
        val value = System.getProperty("windows", windows.toString())
        return value.toBoolean()
    }
}