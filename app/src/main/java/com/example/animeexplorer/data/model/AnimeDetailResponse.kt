package com.example.animeexplorer.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnimeDetailResponse(
    @Json(name = "data")
    val `data`: AnimeDetail,
)

@JsonClass(generateAdapter = true)
data class AnimeDetail(
    @Json(name = "mal_id")
    val mal_id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "synopsis")
    val synopsis: String?,
    @Json(name = "episodes")
    val episodes: Int?,
    @Json(name = "score")
    val score: Double?,
    @Json(name = "images")
    val images: Images,
)

