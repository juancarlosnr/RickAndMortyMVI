package com.example.rickandmortymvi.navigation

sealed class Routes(val route:String) {
    data object Home:Routes("home")
    data object CharacterDetail:Routes("character_detail"){
        fun createRoute(characterId:String) = "$route/$characterId"
    }
}