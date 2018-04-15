package com.commit451.updatewrapper

import org.junit.Assert
import org.junit.Test

/**
 * Test resolution
 */
class VersionTest {

    @Test
    fun fetchVersionTest() {
        val release = GradleVersionGetter.version()
        Assert.assertNotNull(release)
    }

    @Test
    fun parseCurrentVersion() {
        val text = Tester.getFileText("version-output.txt")
        val version = Helper.getVersionFromVersionOutput(text)
        Assert.assertEquals("3.3", version)
    }
}