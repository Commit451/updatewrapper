package com.commit451.updatewrapper

import retrofit2.Retrofit

/**
 * Creates properly configured [GradleSite]s
 */
internal object GradleSiteFactory {

    fun create() : GradleSite {
        return Retrofit.Builder()
                .baseUrl("https://gradle.org/")
                .addConverterFactory(GradleConverterFactory())
                .build()
                .create(GradleSite::class.java)
    }
}