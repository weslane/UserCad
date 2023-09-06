package com.mwsa.domain.util

import org.junit.Assert.assertEquals
import org.junit.Test


class NumberFormatKtTest {

    @Test
    fun toFormatPriceValidTest() {
        val value = "3500"

        val result = value.toFormatPrice()

        assertEquals("R$ 3.500,00", result)
    }
}
