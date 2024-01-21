package com.example.rickandmortymvi.data.remote

import com.example.rickandmortymvi.data.remote.model.DataRickAndMortyDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): Response<DataRickAndMortyDto>
}