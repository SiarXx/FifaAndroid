package com.example.fifaand.tools

import android.util.Log
import com.example.fifaand.Models.Footballer
import com.example.fifaand.helper.Formatter

class Mapper(private val formatter: Formatter) {

    fun map(line: String): Footballer {
    val splited = line.split(";")
    try {
        return (
                Footballer(
                    splited[1].toInt(),
                    splited[2],
                    splited[3].toIntOrNull(),
                    splited[4],
                    splited[5],
                    splited[6],
                    splited[7].toInt(),
                    splited[8].toInt(),
                    splited[9],
                    splited[10],
                    formatter.moneyFormat(splited[11]),
                    formatter.moneyFormat(splited[12]),
                    splited[13].toInt(),
                    splited[14],
                    splited[15].toInt(),
                    splited[16].toInt(),
                    splited[17].toInt(),
                    splited[18],
                    splited[19],
                    splited[20].toBoolean(),
                    splited[21],
                    splited[22].toInt(),
                    formatter.parseDate(splited[23]),
                    splited[24],
                    splited[25],
                    splited[26],
                    splited[27]
                )
                )
    } catch (e: Exception) {
        Log.d("Player","Line does not match the format")
        return Footballer()
    }

}
}
