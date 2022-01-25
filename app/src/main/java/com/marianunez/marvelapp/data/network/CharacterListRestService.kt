package com.marianunez.marvelapp.data.network

import com.marianunez.marvelapp.data.network.response.CharactersListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterListRestService {

    @GET(MarvelApiConstants.CHARACTERS)
    suspend fun getCharacters(
        @Query("apikey") apikey: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("ts") timeStamp: String, //medida de tiempo, le dice cuándo estás haciendo la petición
        @Query("hash") hash: String, //relaciona la public key con la private key
        @Query("orderBy") orderBy: String
    ): CharactersListResponse

}