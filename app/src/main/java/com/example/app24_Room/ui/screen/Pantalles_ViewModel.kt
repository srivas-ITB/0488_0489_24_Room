package com.example.app24_Room.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app24_Room.database.Repository
import com.example.app24_Room.entity.CharacterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class Pantalles_ViewModel : ViewModel() {
    private val repository = Repository()
    private val _character = MutableStateFlow<CharacterEntity?>(null)
    val character: StateFlow<CharacterEntity?> = _character.asStateFlow()

    private val _position = MutableStateFlow<Int>(0)
    val position: StateFlow<Int> = _position.asStateFlow()


    private val _charactersList = MutableStateFlow<MutableList<CharacterEntity>>(mutableListOf())
    val charactersList: StateFlow<MutableList<CharacterEntity>> = _charactersList.asStateFlow()

    private val _error = MutableStateFlow<String>("")
    val error: StateFlow<String> = _error.asStateFlow()


    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {

            _charactersList.value = repository.getFavorites()
            if (_charactersList.value.isEmpty()) {
                _character.value = null
            } else if (_charactersList.value.size < position.value) {
                _character.value = _charactersList.value.get(position.value)
            } else {
                _character.value = null
            }
        }
    }

    fun getCharacterById(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _character.value = repository.getCharacterById(id)
        }
    }

    fun next() {
        _position.update { _position.value + 1 }
        getCharacters()
    }

    fun previous() {
        _position.update { _position.value -1 }
        getCharacters()
    }

    fun saveCharacter(c: CharacterEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.saveAsFavorite(c)
                _error.value = "S'ha afegit el personatge amb èxit"
            } catch (e: Exception) {
                _error.value = "ERROR:: ${e.message}"
            }
        }
    }




}