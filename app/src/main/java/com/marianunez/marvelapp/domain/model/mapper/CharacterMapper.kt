package com.marianunez.marvelapp.domain.model.mapper

import com.marianunez.marvelapp.data.network.response.CharacterResponse
import com.marianunez.marvelapp.domain.model.CharacterModel

fun CharacterResponse.toModel(): CharacterModel =
    CharacterModel(id, name, description, imgUrl = "${thumbnail.path}.${thumbnail.extension}")