package com.example.rickandmortymvi.presentation.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickandmortymvi.domain.model.CharacterBO

@Composable
fun MyGridView(
    characters: List<CharacterBO>,
    characterClicked:(characterId:String) -> Unit
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(4.dp),
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(characters, key = {
            it.id
        }) { character ->
            CharacterItem(character.image){characterClicked(character.id.toString())}
        }
    }
}