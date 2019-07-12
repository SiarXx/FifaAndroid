package com.example.fifaand.Models

import java.io.Serializable

data class Player(
    val id: Int? = null,
    var name: String? = null,
    var age: Int? = null,
    var photo: String? = null,
    var nationality: String? = null,
    var flag: String? = null,
    var overall: Int? = null,
    var potential: Int? = null,
    var club: String? = null,
    var clubLogo: String? = null,
    var value: Double? = null,
    var wage: Double? = null,
    var special: Int? = null,
    var preferredFoot: String? = null,
    var internationalReputation: Int? = null,
    var weakFoot: Int? = null,
    var skillMoves: Int? = null,
    var workRate: String? = null,
    var bodyType: String? = null,
    var realFace: Boolean? = null,
    var position: String? = null,
    var jerseyNumber: Int? = null,
    var joined: Long? = null,
    var loanedFrom: String? = null,
    var contractValidUntil: String? = null,
    var height: String? = null,
    var weight: String? = null
) : Serializable