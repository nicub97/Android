package com.ecodeli.client.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ecodeli.client.screens.HomeScreen
import com.ecodeli.client.screens.AnnonceListScreen
import com.ecodeli.client.screens.AnnonceDetailScreen
import com.ecodeli.client.screens.LoginScreen
import androidx.navigation.compose.navArgument
import androidx.navigation.NavType
import com.google.gson.Gson

object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val ANNONCES = "annonces"
    const val ANNONCE_DETAIL = "annonceDetail"
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN,
        modifier = modifier
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(onLoginSuccess = {
                navController.navigate(Routes.ANNONCES) {
                    popUpTo(Routes.LOGIN) { inclusive = true }
                }
            })
        }
        composable(Routes.HOME) {
            HomeScreen()
        }
        composable(Routes.ANNONCES) {
            AnnonceListScreen(onAnnonceSelected = { annonce ->
                val annonceJson = Gson().toJson(annonce)
                navController.navigate("${Routes.ANNONCE_DETAIL}/$annonceJson")
            })
        }
        composable(
            route = "${Routes.ANNONCE_DETAIL}/{annonce}",
            arguments = listOf(navArgument("annonce") { type = NavType.StringType })
        ) { backStackEntry ->
            val annonceJson = backStackEntry.arguments?.getString("annonce")
            val annonce = Gson().fromJson(annonceJson, com.ecodeli.client.model.Annonce::class.java)
            AnnonceDetailScreen(annonce)
        }
    }
}
