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
        val gradleSite = GradleSiteFactory.create()
        val releaseResponse = gradleSite.getLatestRelease().execute()
        if (releaseResponse.isSuccessful) {
            val releaseName = releaseResponse.body()?.version
            val currentVersion = Helper.getCurrentVersion()
            if (releaseName == null) {
                System.out.println("Unable to fetch latest version of gradle. Please file an issue on GitHub")
                return
            }
            if (currentVersion == releaseName) {
                System.out.println("GradleSite wrapper is already on latest version: $releaseName")
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