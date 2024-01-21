package com.example.rickandmortymvi.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.rickandmortymvi.presentation.composables.MyGridView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(state: HomeScreenState, onEvent: (HomeScreenEvents) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Rick And Morty APP", color = MaterialTheme.colorScheme.onPrimary)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) { pv ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pv),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                MyGridView(characters = state.characters)
            }
        }
    }
}