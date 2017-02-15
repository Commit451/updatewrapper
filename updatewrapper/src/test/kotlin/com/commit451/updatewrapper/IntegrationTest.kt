package com.commit451.updatewrapper

import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert
import org.junit.Test

/**
 * Test the integration
 * @see <a href="https://docs.gradle.org/current/userguide/custom_plugins.html#sec:writing_tests_for_your_plugin">https://docs.gradle.org/current/userguide/custom_plugins.html#sec:writing_tests_for_your_plugin</a>
 */
class IntegrationTest {

    @Test
    fun pluginFoundTest() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.commit451.updatewrapper")
        val task = project.tasks.getByName("updatewrapper")
        Assert.assertTrue(task is UpdateWrapperTask)
    }
}