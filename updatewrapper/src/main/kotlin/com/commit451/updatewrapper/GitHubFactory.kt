package com.commit451.updatewrapper

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Creates properly configured [GitHub]s
 */
internal object GitHubFactory {

    fun create() : GitHub {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(GitHub::class.java)
    }
}