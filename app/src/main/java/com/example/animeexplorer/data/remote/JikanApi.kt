package com.example.animeexplorer.data.remote

import com.example.animeexplorer.data.model.AnimeDetailResponse
import com.example.animeexplorer.data.model.TopAnimeResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface JikanApi {

    @GET("top/anime")
    suspend fun getTopAnime(): TopAnimeResponse

    @GET("anime/{id}")
    suspend fun getAnimeDetail(@Path("id") id: Int): AnimeDetailResponse

    companion object {
        private const val BASE_URL = "https://api.jikan.moe/v4/"
        private val logger =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
        private val httpClient = OkHttpClient.Builder().addInterceptor(logger).build()
        val api: JikanApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(JikanApi::class.java)
        }
    }
}