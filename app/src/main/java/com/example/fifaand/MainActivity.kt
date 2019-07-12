package com.example.fifaand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.fifaand.Models.User
import com.example.fifaand.tools.DBWorkerThread
import com.example.fifaand.viewmodels.PlayerViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import com.example.fifaand.entities.PlayerEntity as PlayerEntity1


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
