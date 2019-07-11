package com.example.fifaand.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*
@Entity
data class Player (@PrimaryKey val id: Int? = null,
                   @ColumnInfo(name = "name") var name: String? = null,
                   @ColumnInfo(name = "age") var age: Int? = null,
                   @ColumnInfo(name = "photo") var photo: String? = null,
                   @ColumnInfo(name = "nationality") var nationality: String? = null,
                   @ColumnInfo(name = "flag") var flag: String? = null,
                   @ColumnInfo(name = "overall") var overall: Int? = null,
                   @ColumnInfo(name = "potential") var potential: Int? = null,
                   @ColumnInfo(name = "club") var club: String? = null,
                   @ColumnInfo(name = "clubLogo") var clubLogo: String? = null,
                   @ColumnInfo(name = "value") var value: Double? = null,
                   @ColumnInfo(name = "wage") var wage: Double? = null,
                   @ColumnInfo(name = "special") var special: Int? = null,
                   @ColumnInfo(name = "preferredFoot") var preferredFoot: String? = null,
                   @ColumnInfo(name = "internationalReputation") var internationalReputation: Int? = null,
                   @ColumnInfo(name = "weakFoot") var weakFoot: Int? = null,
                   @ColumnInfo(name = "skillMoves") var skillMoves: Int? = null,
                   @ColumnInfo(name = "workRate") var workRate: String? = null,
                   @ColumnInfo(name = "bodyType") var bodyType: String? = null,
                   @ColumnInfo(name = "realFace") var realFace: Boolean? = null,
                   @ColumnInfo(name = "position") var position: String? = null,
                   @ColumnInfo(name = "jerseyNumber") var jerseyNumber: Int? = null,
                   @ColumnInfo(name = "joined") var joined: Long? = null,
                   @ColumnInfo(name = "loanedFrom") var loanedFrom: String? = null,
                   @ColumnInfo(name = "contractValidUntil") var contractValidUntil: String? = null,
                   @ColumnInfo(name = "height") var height: String? = null,
                   @ColumnInfo(name = "weight") var weight: String? = null) :Serializable