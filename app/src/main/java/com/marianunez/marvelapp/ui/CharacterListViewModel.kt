package com.marianunez.marvelapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marianunez.marvelapp.domain.CharactersListUseCase
import com.marianunez.marvelapp.domain.model.CharacterModel
import kotlinx.coroutines.launch

class CharacterListViewModel(private val charactersListUseCase: CharactersListUseCase) :
    ViewModel() {

    private val _characterList = MutableLiveData<List<CharacterModel>>()
    val characterList: LiveData<List<CharacterModel>> = _characterList

    fun getCharactersList() {
        viewModelScope.launch {
            _characterList.postValue(charactersListUseCase.getCharactersList())
        }
    }

}