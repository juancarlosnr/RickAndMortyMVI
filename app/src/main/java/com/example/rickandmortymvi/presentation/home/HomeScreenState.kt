package com.example.rickandmortymvi.presentation.home

import com.example.rickandmortymvi.domain.model.CharacterBO

data class HomeScreenState(
    var characters:List<CharacterBO> = listOf(),
    var isLoading:Boolean = false
)
