package com.mwsa.domain.util

import java.text.NumberFormat
import java.util.Locale

fun String.toFormatPrice(): String {

    val value = this.convertToDouble()

    return NumberFormat.getCurrencyInstance(localeBR())
        .format(value)
        .toString()
}

fun String.convertToDouble() =
    NumberFormat.getNumberInstance(localeBR())
        .parse(this)
        .toDouble()

fun localeBR() = Locale("pt", "BR")
