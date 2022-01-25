package com.marianunez.marvelapp.data.network.response

data class CharactersListResponse(
    val code: String,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: CharacterDataContainerResponse
)

data class CharacterDataContainerResponse(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    var results: MutableList<CharacterResponse>
)

data class CharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: ImageResponse
)

data class ImageResponse(
    val path: String,
    val extension: String
)