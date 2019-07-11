package com.example.fifaand.Interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fifaand.Models.Player

@Dao
interface PlayerDao{
    @Query("SELECT * from Player")
    fun getAllPlayers(): List<Player>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPlayer(vararg players: Player)
    @Query("DELETE from Player")
    fun deleteAllPlayers()
}