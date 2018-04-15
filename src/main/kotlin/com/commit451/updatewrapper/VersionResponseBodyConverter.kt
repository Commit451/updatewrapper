package com.commit451.updatewrapper

import okhttp3.ResponseBody
import org.jsoup.Jsoup
import retrofit2.Converter

internal class VersionResponseBodyConverter: Converter<ResponseBody, Version> {

    override fun convert(value: ResponseBody?): Version {
        val html = value?.string()

        val version = Version()
        val document = Jsoup.parse(html)
        //take a look at the structure of the docs page to know that this
        //is getting the latest release from a doc link on said page
        var docsLink = document.getElementsByClass("indent")[1]
                .getElementsByTag("a")[1]
                .attr("href")


        docsLink = docsLink.removePrefix("https://docs.gradle.org/")
        val versionNum = docsLink.removeSuffix("/javadoc/")

        version.version = versionNum

        value?.close()
        return version
    }
}