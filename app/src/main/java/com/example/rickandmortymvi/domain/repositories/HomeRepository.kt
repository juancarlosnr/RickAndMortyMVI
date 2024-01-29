package com.example.rickandmortymvi.domain.repositories

import com.example.rickandmortymvi.core.Resources
import com.example.rickandmortymvi.domain.model.CharacterBO
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getCharacters(): Flow<Resources<List<CharacterBO>>>
    fun getCharacterById(characterId:String):Flow<Resources<CharacterBO>>
}