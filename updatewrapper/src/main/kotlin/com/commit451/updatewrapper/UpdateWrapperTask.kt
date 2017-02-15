package com.commit451.updatewrapper

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

/**
 * The task that actually converts things
 */
open class UpdateWrapperTask : DefaultTask() {

    init {
        description = "Updates gradle wrapper to latest version"
        group = "Help"
    }

    @Input
    var verbose = false

    @TaskAction
    fun updatewrapper() {

    }

    fun verbose(): Boolean {
        val value = System.getProperty("verbose", verbose.toString())
        return value.toBoolean()
    }
}