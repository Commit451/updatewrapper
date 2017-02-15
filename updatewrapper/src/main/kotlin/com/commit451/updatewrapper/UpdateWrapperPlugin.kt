package com.commit451.updatewrapper

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Behold the plugin
 */
class UpdateWrapperPlugin : Plugin<Project> {

    override fun apply(project: Project?) {
        project!!.tasks.create("updatewrapper", UpdateWrapperTask::class.java)
    }
}
