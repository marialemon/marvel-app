package com.marianunez.marvelapp.data.datasource.cloud

import com.marianunez.marvelapp.data.network.CharacterListRestService
import com.marianunez.marvelapp.data.network.MarvelFactoryService
import com.marianunez.marvelapp.data.network.md5
import com.marianunez.marvelapp.data.network.response.CharactersListResponse
import org.koin.core.component.KoinComponent
import java.util.*

class CharacterListDatasource(private val marvelFactoryService: MarvelFactoryService):
    KoinComponent {

    companion object {
        private const val PUBLIC_KEY = "6d2db12059caa4590ef4cb68b359cea8"
        private const val SECRET_KEY = "5b46d224e41ceebe7d50f9ffa5e858c70f943432"
    }

    private var timeStamp: String = Date().time.toString()

    private fun getDataForMarvelServerAuthentication(): String = (timeStamp + SECRET_KEY + PUBLIC_KEY).md5()

    suspend fun getCharactersList(): CharactersListResponse {
        val api = marvelFactoryService.createApi(CharacterListRestService::class.java)
        return api.getCharacters(PUBLIC_KEY, 30, 0, timeStamp, getDataForMarvelServerAuthentication(), "name")
    }

}