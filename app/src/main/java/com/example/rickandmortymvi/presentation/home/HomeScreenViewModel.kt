package com.example.rickandmortymvi.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortymvi.core.Resources
import com.example.rickandmortymvi.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase): ViewModel() {

    var state by mutableStateOf(HomeScreenState())
    private set

    init {
        getCharacters()
    }

    fun onEvent(event: HomeScreenEvents) {
        when(event){

        }
    }

    private fun getCharacters() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            getCharactersUseCase().collect { result ->
                when (result) {
                    is Resources.Success -> {
                        result.data?.let { listCharacters ->
                            state = state.copy(
                                isLoading = false,
                                characters = listCharacters
                            )
                        }
                    }
                    is Resources.Error -> {/* Do nothing */}
                }
            }
        }
        state = state.copy(isLoading = false)
    }
}