package com.example.animeexplorer.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeexplorer.data.AnimeRepository
import com.example.animeexplorer.data.model.AnimeDetail
import kotlinx.coroutines.launch

class AnimeDetailViewModel(private val repo: AnimeRepository) : ViewModel() {
    private val _animeDetail = MutableLiveData<AnimeDetail?>()
    val animeDetail: LiveData<AnimeDetail?> = _animeDetail

    fun loadAnimeDetail(id: Int) {
        viewModelScope.launch {
            try {
                val detail = repo.fetchAnimeDetail(id)
                _animeDetail.postValue(detail)
            } catch (e: Exception) {
                _animeDetail.postValue(null)
            }
        }
    }

}