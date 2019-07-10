package com.example.fifaand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fifaand.Models.User

class MainActivity : AppCompatActivity() {
    var users = arrayListOf(User("a","mleko@mleko.pl","a"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
