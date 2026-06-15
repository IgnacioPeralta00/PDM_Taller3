package com.pdmcourse2026.RankeUca.ui.screens.option

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.pdmcourse2026.RankeUca.RankeUcaApplication
import com.pdmcourse2026.RankeUca.data.repositories.OptionRepositoryImpl
import com.pdmcourse2026.RankeUca.data.repositories.OptionRepository
import com.pdmcourse2026.RankeUca.models.Option
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class OptionsViewModel(
    private val optionRepository: OptionRepository
) : ViewModel() {

    val options: StateFlow<List<Option>> =
        optionRepository.getOptions()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addOption(name: String, imageUrl: String) {
        viewModelScope.launch {
            optionRepository.addOption(Option(name = name, imageUrl = imageUrl))
        }
    }

    fun deleteOption(option: Option) {
        viewModelScope.launch {
            optionRepository.deleteOption(option)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as RankeUcaApplication
                OptionsViewModel(app.appProvider.provideOptionRepository())
            }
        }
    }
}



/*
class OptionViewModel : ViewModel() {
    private val placesRepository : OptionRepository = OptionRepositoryImpl()
    private val _uiState = MutableStateFlow(VotesUiState(loading = true))
    val uiState = _uiState.asStateFlow()

    */
/*init {
        loadVotes()
    }*//*


    fun loadVotes() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(loading = true, error = null)
            placesRepository.getPlaces()
                .onSuccess { places ->
                    // Ordenar de mas votos a menos y pasar la UI
                    _uiState.value = VotesUiState(
                        options = places.sortedByDescending { it.votes },
                        loading = false
                    )
                }
                .onFailure { error ->
                    _uiState.value = VotesUiState(
                        error = error.message,
                        loading = false
                    )
                }
        }
    }

    fun refreshVotes() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isRefreshing = true)
            placesRepository.getPlaces()
                .onSuccess { places ->
                    _uiState.value = VotesUiState(
                        options = places.sortedByDescending { it.votes },
                        loading = false,
                        isRefreshing = false
                    )
                }
                    .onFailure { error ->
                    _uiState.value = VotesUiState(
                        error = error.message,
                        loading = false,
                        isRefreshing = false
                    )
                    }
        }
    }
}*/
