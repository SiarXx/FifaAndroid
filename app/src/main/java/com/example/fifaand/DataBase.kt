package com.example.fifaand

import android.content.ContentResolver
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fifaand.Interfaces.PlayerDao
import com.example.fifaand.Interfaces.UserDao
import com.example.fifaand.Models.Player
import com.example.fifaand.Models.User
import com.example.fifaand.helper.Converters

@Database(
    entities = [
        Player::class,
        User::class
    ], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun PlayerDao(): PlayerDao
    abstract fun UserDao(): UserDao

    companion object{
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase?{
            if(instance == null){
                synchronized(AppDatabase::class){
                    instance = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"appDataBase.db").allowMainThreadQueries().build()
                }
            }
            return instance
        }
        fun destroyInstance(){
            instance = null
        }
    }
}