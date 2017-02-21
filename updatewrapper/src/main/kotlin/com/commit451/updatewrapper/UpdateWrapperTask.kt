package com.commit451.updatewrapper

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * The task that actually converts things
 */
open class UpdateWrapperTask : DefaultTask() {

    init {
        description = "Updates gradle wrapper to latest version"
        group = "Help"
    }

    @TaskAction
    fun updatewrapper() {
        val gitHub = GitHubFactory.create()
        val releaseResponse = gitHub.getLatestRelease("gradle", "gradle").execute()
        if (releaseResponse.isSuccessful) {
            val releaseName = releaseResponse.body().name
            val currentVersion = Helper.getCurrentVersion()
            if (currentVersion == releaseName) {
                System.out.println("Gradle wrapper is already on latest version: $releaseName")
            } else {
                System.out.println("Updating wrapper to version $releaseName")

                val exitValue = Helper.runUpdateCommand(releaseName)
                if (exitValue == 0) {
                    System.out.println("Updated gradle wrapper successfully to version $releaseName")
                } else {
                    System.out.println("Unable to run gradle command")
                }
            }
        } else {
            System.out.println("Unable to get latest gradle version to update to")
        }
    }
}