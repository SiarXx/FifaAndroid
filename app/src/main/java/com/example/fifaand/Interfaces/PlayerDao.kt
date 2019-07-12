package com.example.fifaand.Interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fifaand.Models.Player
import com.example.fifaand.entities.PlayerEntity

@Dao
interface PlayerDao{
    @Query("SELECT * from PlayerEntity")
    fun getAllPlayers(): List<PlayerEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPlayer(vararg players: PlayerEntity)

    @Query("DELETE from PlayerEntity")
    fun deleteAllPlayers()

    @Query("SELECT * from PlayerEntity WHERE id == :id")
    fun getPlayerPosition(id: Int): List<PlayerEntity>
}