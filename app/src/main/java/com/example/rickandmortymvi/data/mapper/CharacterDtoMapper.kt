package com.example.rickandmortymvi.data.mapper

import com.example.rickandmortymvi.domain.model.CharacterBO
import com.example.rickandmortymvi.data.remote.model.CharacterDto

fun CharacterDto?.toCharacterBO(): CharacterBO =
    CharacterBO(
        id = this?.id ?: 0,
        name = this?.name ?: "",
        image = this?.image ?: ""
    )