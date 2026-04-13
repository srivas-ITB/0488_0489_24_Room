package com.example.app24_Room.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app24_Room.database.Repository
import com.example.app24_Room.entity.CharacterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Pantalla1_ViewModel: ViewModel() {
    private val repository = Repository()
    private val _character = MutableStateFlow<CharacterEntity?>(null)
    val character: StateFlow<CharacterEntity?> = _character.asStateFlow()



    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getFavorites()

            if (response.isEmpty()) {
                _character.value =  null
            } else {
                _character.value = response.get(0)
            }
        }
    }

    fun saveCharacter(c: CharacterEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveAsFavorite(c)
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