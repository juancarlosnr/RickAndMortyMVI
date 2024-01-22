package com.example.rickandmortymvi.presentation.characterdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.rickandmortymvi.core.util.Util.CHARACTER_ID
import javax.inject.Inject

class CharacterDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle): ViewModel(
){

    var state by mutableStateOf(CharacterDetailState())
        private set

    private val characterId: String? = savedStateHandle[CHARACTER_ID]
}