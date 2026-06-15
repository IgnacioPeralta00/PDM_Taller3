package com.pdmcourse2026.RankeUca.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdmcourse2026.RankeUca.data.repositories.OptionRepositoryImpl
import com.pdmcourse2026.RankeUca.data.repositories.OptionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/*
class HomeViewModel : ViewModel() {
    private val placesRepository : OptionRepository = OptionRepositoryImpl()
    private val _uiState = MutableStateFlow(HomeUiState(loading = true))
    val uiState = _uiState.asStateFlow()


    init {
        loadHome()
    }

    fun loadHome() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(loading = true, error = null)
            placesRepository.getPlaces()
                .onSuccess { places ->
                    _uiState.value = _uiState.value.copy(
                        options = places,
                        loading = false
                    )
                }
                .onFailure { error ->
                    _uiState.value = HomeUiState(
                        error = error.message,
                        loading = false
                    )
                }
        }
    }

    fun refreshHome() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isRefreshing = true)
            placesRepository.getPlaces()
                .onSuccess { places ->
                    _uiState.value = HomeUiState(
                        options = places,
                        loading = false,
                        isRefreshing = false
                    )
                }
                .onFailure { error ->
                    _uiState.value = HomeUiState(
                        error = error.message,
                        loading = false,
                        isRefreshing = false
                    )
                }
        }
    }

    fun votePlace(placeId: Int, onVoteSuccess: () -> Unit) {
        viewModelScope.launch {
            placesRepository.votePlace(placeId)
                .onSuccess {
                    onVoteSuccess()
                }
                .onFailure { error ->
                    _uiState.value = HomeUiState(
                        error = error.message,
                        loading = false
                    )
                }

        }
    }


}*/
