package com.example.rickandmortymvi.presentation.characterdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortymvi.core.Resources
import com.example.rickandmortymvi.core.util.Util.CHARACTER_ID
import com.example.rickandmortymvi.domain.usecases.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    var state by mutableStateOf(CharacterDetailState())
        private set

    private val characterId: String? = savedStateHandle[CHARACTER_ID]

    init {
        getCharacterById()
    }

    private fun getCharacterById() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            getCharacterByIdUseCase(characterId.orEmpty()).collect { result ->
                when (result) {
                    is Resources.Success -> {
                        result.data?.let { character ->
                            state = state.copy(
                                isLoading = false,
                                character = character
                            )
                        }
                    }

                    is Resources.Error -> {/* Do nothing */
                    }
                }
            }
        }
        state = state.copy(isLoading = false)
    }
}