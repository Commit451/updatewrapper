package com.commit451.updatewrapper

import okhttp3.OkHttpClient
import okhttp3.Request

object GradleVersionGetter {

    private val client by lazy {
        OkHttpClient()
    }

    private val request by lazy {
        Request.Builder()
                .url("https://gradle-version.glitch.me/")
                .build()
    }

    fun version() : String? {
        val response = client.newCall(request).execute()
        return response.body()?.string()
    }
}