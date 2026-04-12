package com.example.app24_Room.database

import com.example.app24_Room.CharacterApplication
import com.example.app24_Room.entity.CharacterEntity

class Repository {
    val daoInterface = CharacterApplication.database.characterDao()
    //Database functions
    suspend fun saveAsFavorite(character: CharacterEntity) = daoInterface.addCharacter(character)
    suspend fun deleteFavorite(character: CharacterEntity) = daoInterface.deleteCharacter(character)
    suspend fun isFavorite(characterId: Int) = daoInterface.getCharacterById(characterId)
    suspend fun getFavorites() = daoInterface.getAllCharacters()
}
