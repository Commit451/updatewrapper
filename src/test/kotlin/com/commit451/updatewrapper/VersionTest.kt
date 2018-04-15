package com.commit451.updatewrapper

import org.junit.Assert
import org.junit.Test

/**
 * Test resolution
 */
class VersionTest {

    @Test
    fun fetchVersionTest() {
        val gradleSite = GradleSiteFactory.create()
        val releaseResponse = gradleSite.getLatestRelease().execute()
        val release = releaseResponse.body()
        Assert.assertNotNull(release)
        Assert.assertNotNull(releaseResponse.body()?.version)
    }

    @Test
    fun parseCurrentVersion() {
        val text = Tester.getFileText("version-output.txt")
        val version = Helper.getVersionFromVersionOutput(text)
        Assert.assertEquals("3.3", version)
    }
}