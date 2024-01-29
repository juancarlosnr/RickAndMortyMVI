package com.example.rickandmortymvi.data.remote

import com.example.rickandmortymvi.data.remote.model.CharacterDto
import com.example.rickandmortymvi.data.remote.model.DataRickAndMortyDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): Response<DataRickAndMortyDto>

    @GET("character/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") id: String
    ):Response<CharacterDto>
}