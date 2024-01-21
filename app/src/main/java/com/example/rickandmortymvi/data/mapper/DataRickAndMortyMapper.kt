package com.example.rickandmortymvi.data.mapper

import com.example.rickandmortymvi.domain.model.CharacterBO
import com.example.rickandmortymvi.data.remote.model.DataRickAndMortyDto

fun DataRickAndMortyDto?.toCharacterList():List<CharacterBO>{
    return this?.results?.map {
        it.toCharacterBO()
    } ?: listOf()
}