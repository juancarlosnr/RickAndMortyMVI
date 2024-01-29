package com.example.rickandmortymvi.data.repositories

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.rickandmortymvi.core.Resources
import com.example.rickandmortymvi.data.mapper.toCharacterBO
import com.example.rickandmortymvi.data.mapper.toCharacterList
import com.example.rickandmortymvi.domain.model.CharacterBO
import com.example.rickandmortymvi.domain.repositories.HomeRepository
import com.example.rickandmortymvi.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): HomeRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getCharacters(): Flow<Resources<List<CharacterBO>>> {
        return flow {
            val response = try {
               apiService.getCharacters()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            }

            emit(Resources.Success(data = response?.body().toCharacterList()))
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getCharacterById(characterId: String): Flow<Resources<CharacterBO>> {
        return flow {
            val response = try {
                apiService.getCharacterById(characterId)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            }

            emit(Resources.Success(data = response?.body().toCharacterBO()))
        }
    }

}