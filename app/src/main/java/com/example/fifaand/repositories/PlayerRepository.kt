package com.example.fifaand.repositories

import android.app.Application
import androidx.annotation.WorkerThread
import com.example.fifaand.AppDatabase
import com.example.fifaand.entities.PlayerEntity


class PlayerRepository(application: Application){
    val dB = AppDatabase.getInstance(application)
    val playerDao = dB!!.PlayerDao()
    val allPlayers = playerDao.getAllPlayers()

    @WorkerThread
    suspend fun insertPlayers(players: List<PlayerEntity>) {
    playerDao.insertPlayer(*players.toTypedArray())
    }



}