package com.example.app24_Room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var fistName: String,
    var phoneNumber: String
)
