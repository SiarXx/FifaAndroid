package com.example.fifaand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fifaand.Models.User
import com.example.fifaand.tools.DBWorkerThread

class MainActivity : AppCompatActivity() {
    var users = arrayListOf(User(1, "a","mleko@mleko.pl","a"))
    lateinit var dbWorker: DBWorkerThread
    var mDb: AppDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbWorker = DBWorkerThread("dbWorker")
        dbWorker.start()
        mDb = AppDatabase.getInstance(this)
    }
}
