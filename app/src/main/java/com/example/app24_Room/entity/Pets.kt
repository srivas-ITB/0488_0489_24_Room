package com.example.app24_Room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
    entity = Person::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("ownerId"),
    onDelete = ForeignKey.CASCADE
)]
)
data class Pet(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String,
    var ownerId: Long
)
