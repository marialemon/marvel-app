package com.marianunez.marvelapp.data.repository

import com.marianunez.marvelapp.data.datasource.cloud.CharacterListDatasource
import com.marianunez.marvelapp.data.network.response.CharactersListResponse
import org.koin.core.component.KoinComponent

class CharacterListRepositoryImpl(private val characterListDatasource: CharacterListDatasource) : CharacterListRepository, KoinComponent{

    override suspend fun getCharactersList(): CharactersListResponse {
        return characterListDatasource.getCharactersList()
    }

}