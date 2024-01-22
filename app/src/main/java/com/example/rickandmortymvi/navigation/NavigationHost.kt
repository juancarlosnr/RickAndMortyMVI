package com.example.rickandmortymvi.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortymvi.presentation.characterdetail.CharacterDetailScreen
import com.example.rickandmortymvi.presentation.characterdetail.CharacterDetailViewModel
import com.example.rickandmortymvi.presentation.home.HomeScreen
import com.example.rickandmortymvi.presentation.home.HomeScreenViewModel

@Composable
fun NavigationHost(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController, startDestination = Routes.Home.route
    ) {
        composable(route = Routes.Home.route) {
            val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
            HomeScreen(
                state = homeScreenViewModel.state
            ) { characterId ->
                navHostController.navigate(route = Routes.CharacterDetail.createRoute(characterId))
            }
        }

        composable(
            route = "${Routes.CharacterDetail.route}/{${NavArgs.CharacterId.key}}",
            arguments = listOf(navArgument(NavArgs.CharacterId.key) {
                type = NavType.StringType
            })
        ) {
            val characterDetailViewModel = hiltViewModel<CharacterDetailViewModel>()
            CharacterDetailScreen(
                state = characterDetailViewModel.state
            ) { navHostController.popBackStack() }
        }

    }

}