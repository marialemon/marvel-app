package com.marianunez.marvelapp.domain.model.mapper

import com.marianunez.marvelapp.data.network.response.CharacterResponse
import com.marianunez.marvelapp.domain.model.CharacterModel


fun CharacterResponse.toModel(): CharacterModel {
    val imgUrl2 = "${thumbnail.path}.${thumbnail.extension}"
    val imgUrl = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"

    return CharacterModel(id, name, description, imgUrl = imgUrl)
}
