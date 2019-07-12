package com.example.fifaand.tools

import com.example.fifaand.Models.Player
import com.example.fifaand.entities.PlayerEntity

class PlayerToEntityMapper{
    fun mapE(player: Player): PlayerEntity{
        return PlayerEntity(player.id,
            player.name,
            player.age,
            player.photo,
            player.nationality,
            player.flag,
            player.overall,
            player.clubLogo,
            player.preferredFoot,
            player.weakFoot,
            player.skillMoves,
            player.position,
            player.jerseyNumber,
            player.height,
            player.weight)
    }
}