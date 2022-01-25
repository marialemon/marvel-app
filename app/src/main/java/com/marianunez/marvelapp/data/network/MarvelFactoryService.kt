package com.marianunez.marvelapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelFactoryService {

    companion object {
        private const val BASE_URL = "https://gateway.marvel.com"
    }

    fun <T> createApi(apiClass: Class<T>): T {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiClass)
    }

}