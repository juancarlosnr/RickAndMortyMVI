package com.example.rickandmortymvi.di

import com.example.rickandmortymvi.data.repositories.HomeRepositoryImpl
import com.example.rickandmortymvi.domain.repositories.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMainRepository(homeRepositoryImpl:HomeRepositoryImpl):HomeRepository
}