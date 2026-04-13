package com.example.app24_Room.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app24_Room.database.Repository
import com.example.app24_Room.entity.CharacterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Pantalles_ViewModel : ViewModel() {
    private val repository = Repository()
    private val _character = MutableStateFlow<CharacterEntity?>(null)
    val character: StateFlow<CharacterEntity?> = _character.asStateFlow()

    private val _error = MutableStateFlow<String>("")
    val error: StateFlow<String> = _error.asStateFlow()


    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {

            val response = repository.getFavorites()
            if (response.isEmpty()) {
                _character.value = null
            } else {
                _character.value = response.get(0)
            }
        }
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

//    fun getCharacterByUrl(url:String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = repository.getCharacterByUrl(url)
//            withContext(Dispatchers.Main) {
//                if (response.isSuccessful) {
//                    _character.value = response.body()
//                } else {
//                    Log.e("Error :", response.message())
//                }
//            }
//        }
//    }
}