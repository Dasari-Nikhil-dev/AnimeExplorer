package com.example.animeexplorer.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeexplorer.data.AnimeRepository
import com.example.animeexplorer.data.model.AnimeSummary
import kotlinx.coroutines.launch

class AnimeListViewModel(private val repo: AnimeRepository) : ViewModel() {
    private val _topAnime = MutableLiveData<List<AnimeSummary>>()
    val topAnime: LiveData<List<AnimeSummary>> = _topAnime

    init {
        loadTopAnime()
    }

    fun loadTopAnime() = viewModelScope.launch {
        try {
            val list = repo.fetchTopAnime()
            _topAnime.postValue(list)
        } catch (e: Exception) {
            _topAnime.postValue(emptyList())
        }
    }
}