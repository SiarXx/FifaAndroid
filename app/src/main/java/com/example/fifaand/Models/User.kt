package com.example.fifaand.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity


data class User(
    @PrimaryKey(autoGenerate = true) var ID: Long?,
    @ColumnInfo(name = "Login") var login: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String
)