package com.commit451.updatewrapper

import retrofit2.Call
import retrofit2.http.GET

/**
 * To get the version
 */
internal interface GradleSite {

    @GET("docs")
    fun getLatestRelease() : Call<Version>
}