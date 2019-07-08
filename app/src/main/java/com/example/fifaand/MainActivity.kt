package com.example.fifaand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fifaand.Models.User

class MainActivity : AppCompatActivity() {
    var users = arrayListOf(User("mleko","mleko@mleko.pl","mleko"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
