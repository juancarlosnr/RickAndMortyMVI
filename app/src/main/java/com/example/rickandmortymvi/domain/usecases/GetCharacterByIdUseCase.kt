package com.example.rickandmortymvi.domain.usecases

import com.example.rickandmortymvi.core.Resources
import com.example.rickandmortymvi.domain.model.CharacterBO
import com.example.rickandmortymvi.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    operator fun invoke(characterId:String): Flow<Resources<CharacterBO>> {
        return homeRepository.getCharacterById(characterId)
    }
}