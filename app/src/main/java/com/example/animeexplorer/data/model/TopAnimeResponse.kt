package com.example.animeexplorer.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopAnimeResponse(
    @Json(name = "data")
    val data: List<AnimeSummary>
)

@JsonClass(generateAdapter = true)
data class AnimeSummary(
    @Json(name = "mal_id")
    val malId: Int,
    @Json(name = "images")
    val images: Images,
    @Json(name = "title")
    val title: String,
    @Json(name = "episodes")
    val episodes: Int?,
    @Json(name = "score")
    val score: Double?
)

@JsonClass(generateAdapter = true)
data class Images(
    @Json(name = "jpg")
    val jpg: Jpg
)

@JsonClass(generateAdapter = true)
data class Jpg(
    @Json(name = "image_url")
    val imageUrl: String
)
