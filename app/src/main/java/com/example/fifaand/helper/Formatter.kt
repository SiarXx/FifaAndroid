package com.example.fifaand.helper

import java.text.SimpleDateFormat
import java.util.*
import kotlin.Exception as Exception1

class Formatter {

    fun moneyFormat(value: String): Double {
        return try {
            val cleanedValue = value.trim().removeRange(0, 1)
            val multiplier = when (cleanedValue.last()) {
                'M' -> 1_000_000
                'K' -> 1_000
                else -> 1
            }

            getAmount(cleanedValue, multiplier)

        } catch (e: Exception) {
            0.0
        }
    }

    private fun getAmount(value: String, multiplier: Int): Double {
        val amount = value.substring(0, value.length - 1).toDouble()
        return (amount * multiplier)
    }
    fun parseDate(date: String): Date? {
        if (date.isEmpty())
            return null
        return SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH).parse(date)
    }
}