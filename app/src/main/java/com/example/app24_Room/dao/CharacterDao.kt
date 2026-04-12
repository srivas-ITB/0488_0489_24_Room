package com.example.app24_Room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.app24_Room.entity.CharacterEntity

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CharacterEntity")
    suspend fun getAllCharacters(): MutableList<CharacterEntity>
    @Query("SELECT * FROM CharacterEntity WHERE id = :characterId")
    suspend fun getCharacterById(characterId: Int): CharacterEntity
    @Insert
    suspend fun addCharacter(character: CharacterEntity)
    @Delete
    suspend fun deleteCharacter(character: CharacterEntity)
}
