package com.example.cinemasearch.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemasearch.data.DTOmodel.FilmById
import com.example.cinemasearch.data.repository.CinemaSearchRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailMovieViewModel: ViewModel() {
    private val singleCharacterLiveData = MutableLiveData<FilmById>()
    val singleCharacter: LiveData<FilmById> = singleCharacterLiveData
    private var job: Job? = null
    private val repository = CinemaSearchRepository()
    private val isLoadingLiveData = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean> = isLoadingLiveData

    fun getSingleCharacter(id: Int) {
        job?.cancel()
        job = viewModelScope.launch {
            kotlin.runCatching {
                repository.getSingleMovie(id)
            }.onSuccess {
                isLoadingLiveData.postValue(false)
                singleCharacterLiveData.postValue(it)
            }.onFailure {
                    isLoadingLiveData.postValue(false)
                    val tmp = it
            }
        }
    }
}