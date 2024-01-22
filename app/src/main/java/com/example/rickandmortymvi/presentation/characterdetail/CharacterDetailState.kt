package com.example.rickandmortymvi.presentation.characterdetail

import com.example.rickandmortymvi.domain.model.CharacterBO

data class CharacterDetailState(
    var character:CharacterBO = CharacterBO(0,"",""),
    var isLoading:Boolean = false
)