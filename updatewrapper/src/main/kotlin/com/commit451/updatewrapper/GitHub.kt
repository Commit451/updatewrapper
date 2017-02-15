package com.commit451.updatewrapper

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * To get the version
 */
internal interface GitHub {

    @GET("repos/{group}/{repo}/releases/latest")
    fun getLatestRelease(@Path("group") group: String,
                         @Path("repo") repo: String) : Call<Release>
}