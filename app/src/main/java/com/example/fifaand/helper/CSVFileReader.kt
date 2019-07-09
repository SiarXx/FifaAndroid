package com.example.fifaand.helper

import java.io.File

class CSVFileReader{
    fun readFileByLine(fileName: String): ArrayList<String> {
        val fileReader = File(fileName).bufferedReader()
        val lines = fileReader.readLines() as ArrayList<String>
        lines.removeAt(0)
        return lines
    }
}