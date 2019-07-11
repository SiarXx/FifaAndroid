package com.example.fifaand.Interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.fifaand.Models.User

@Dao
interface UserDao{
    @Query("SELECT * from User")
    fun getAllUsers(): List<User>
    @Insert(onConflict = REPLACE)
    fun insertUser(user: User)
}