package com.example.animeexplorer.data

import com.example.animeexplorer.data.local.AnimeDao
import com.example.animeexplorer.data.local.AnimeDetailEntity
import com.example.animeexplorer.data.local.AnimeSummaryEntity
import com.example.animeexplorer.data.model.AnimeDetail
import com.example.animeexplorer.data.model.AnimeSummary
import com.example.animeexplorer.data.model.Images
import com.example.animeexplorer.data.model.Jpg
import com.example.animeexplorer.data.remote.JikanApi

class AnimeRepository(val dao: AnimeDao) {
    private val api = JikanApi.api

    suspend fun fetchTopAnime(): List<AnimeSummary> {
        return try {
            val response = api.getTopAnime()
            // save to DB
            val entities = response.data.map { anime ->
                AnimeSummaryEntity(
                    malId = anime.malId,
                    title = anime.title,
                    imageUrl = anime.images.jpg.imageUrl,
                    episodes = anime.episodes,
                    score = anime.score
                )
            }
            dao.insertTopAnime(entities)
            response.data
        } catch (e: Exception) {
            val entities = dao.getTopAnime()
            entities.map { entity ->
                AnimeSummary(
                    malId = entity.malId,
                    title = entity.title,
                    images = Images(
                        jpg = Jpg(entity.imageUrl)
                    ),
                    episodes = entity.episodes,
                    score = entity.score
                )
            }
        }
    }

    suspend fun fetchAnimeDetail(id: Int): AnimeDetail {
        return try {
            val response = api.getAnimeDetail(id).data
            //Save to DB
            val entities = AnimeDetailEntity(
                malId = response.mal_id,
                title = response.title,
                imageUrl = response.images.jpg.imageUrl,
                episodes = response.episodes,
                score = response.score,
                synopsis = response.synopsis,
            )
            dao.insertAnimeDetail(entities)
            response
        } catch (e: Exception) {
            dao.getAnimeDetail(id)?.let { entity ->
                AnimeDetail(
                    mal_id = entity.malId,
                    title = entity.title,
                    synopsis = entity.synopsis,
                    images = Images(
                        jpg = Jpg(entity.imageUrl)
                    ),
                    episodes = entity.episodes,
                    score = entity.score,
                )
            } ?: throw e
        }
    }
}