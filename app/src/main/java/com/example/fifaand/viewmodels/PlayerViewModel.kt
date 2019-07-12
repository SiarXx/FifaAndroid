package com.example.fifaand.viewmodels

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fifaand.entities.PlayerEntity
import com.example.fifaand.repositories.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel (application: Application): ViewModel(){
    private val playerRepository = PlayerRepository(application)
    fun getAllPlayers() = playerRepository.allPlayers

    fun putAllPlayers(players: List<PlayerEntity>) = viewModelScope.launch(Dispatchers.IO){
        playerRepository.insertPlayers(players)
    }

}