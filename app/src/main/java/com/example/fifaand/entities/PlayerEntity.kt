package com.example.fifaand.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayerEntity(
    @PrimaryKey val id: Int? = null,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "age") var age: Int? = null,
    @ColumnInfo(name = "photo") var photo: String? = null,
    @ColumnInfo(name = "nationality") var nationality: String? = null,
    @ColumnInfo(name = "flag") var flag: String? = null,
    @ColumnInfo(name = "overall") var overall: Int? = null,
    @ColumnInfo(name = "potential") var potential: Int? = null,
    @ColumnInfo(name = "clubLogo") var clubLogo: String? = null,
    @ColumnInfo(name = "preferredFoot") var preferredFoot: String? = null,
    @ColumnInfo(name = "weakFoot") var weakFoot: Int? = null,
    @ColumnInfo(name = "skillMoves") var skillMoves: Int? = null,
    @ColumnInfo(name = "position") var position: String? = null,
    @ColumnInfo(name = "jerseyNumber") var jerseyNumber: Int? = null,
    @ColumnInfo(name = "height") var height: String? = null,
    @ColumnInfo(name = "weight") var weight: String? = null
    )