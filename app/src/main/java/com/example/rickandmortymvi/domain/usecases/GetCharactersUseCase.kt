package com.example.rickandmortymvi.domain.usecases

import com.example.rickandmortymvi.core.Resources
import com.example.rickandmortymvi.domain.model.CharacterBO
import com.example.rickandmortymvi.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    operator fun invoke(): Flow<Resources<List<CharacterBO>>> {
        return homeRepository.getCharacters()
    }
}