package com.example.animeexplorer.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.animeexplorer.data.AnimeRepository
import com.example.animeexplorer.ui.detail.AnimeDetailViewModel
import com.example.animeexplorer.ui.list.AnimeListViewModel

class AnimeViewModelFactory(
    private val repo: AnimeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AnimeListViewModel::class.java) ->
                AnimeListViewModel(repo) as T

            modelClass.isAssignableFrom(AnimeDetailViewModel::class.java) ->
                AnimeDetailViewModel(repo) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
