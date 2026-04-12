package com.example.app24_Room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CharacterEntity")
data class CharacterEntity(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val birthYear: String,
    val eye_color: String,
    val gender: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val url: String
)
