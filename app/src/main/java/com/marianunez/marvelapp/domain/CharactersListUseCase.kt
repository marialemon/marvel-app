package com.marianunez.marvelapp.domain

import com.marianunez.marvelapp.data.repository.CharacterListRepository
import com.marianunez.marvelapp.domain.model.CharacterModel
import com.marianunez.marvelapp.domain.model.mapper.toModel
import org.koin.core.component.KoinComponent

class CharactersListUseCase(private val characterListRepository: CharacterListRepository): KoinComponent {

    suspend fun getCharactersList(): List<CharacterModel> {
        val response = characterListRepository.getCharactersList()
        return response.data.results.map { it.toModel() }
    }

}