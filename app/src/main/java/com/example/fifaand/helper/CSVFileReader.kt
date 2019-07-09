package com.example.fifaand.helper

import android.content.ContentResolver
import android.net.Uri
import java.io.BufferedReader
import java.io.InputStreamReader

class CSVFileReader{
    fun readFileByLine(contentResolver: ContentResolver, uri: Uri): ArrayList<String> {
        val csvFile = contentResolver.openInputStream(uri)
        val isr = InputStreamReader(csvFile)
        val list = ArrayList(BufferedReader(isr).readLines())
        list.removeAt(0)
        return list
    }
}