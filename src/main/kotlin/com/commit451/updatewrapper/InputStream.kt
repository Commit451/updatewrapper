package com.commit451.updatewrapper

import java.io.ByteArrayOutputStream
import java.io.InputStream

fun InputStream.convertToString(): String {
    val result = ByteArrayOutputStream()
    val buffer = ByteArray(1024)
    var length = 0

    while ({ length = read(buffer); length }() != -1) {
        result.write(buffer, 0, length)
    }
    return result.toString("UTF-8")
}
