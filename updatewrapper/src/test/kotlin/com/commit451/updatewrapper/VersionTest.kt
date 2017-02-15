package com.commit451.updatewrapper

import org.junit.Assert
import org.junit.Test

/**
 * Test resolution
 */
class VersionTest {

    @Test
    fun fetchVersionTest() {
        val group = "gradle"
        val name = "gradle"
        val github = GitHubFactory.create()
        val releaseResponse = github.getLatestRelease(group, name).execute()
        val release = releaseResponse.body()
        Assert.assertNotNull(release)
    }
}