package com.marianunez.marvelapp.data.repository

import com.marianunez.marvelapp.data.network.response.CharactersListResponse
import org.koin.core.component.KoinComponent

interface CharacterListRepository: KoinComponent {

    suspend fun getCharactersList(): CharactersListResponse

}