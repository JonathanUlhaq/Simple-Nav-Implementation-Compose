package com.belajar.decodeencodelanjutan.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationAdapter() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = Route.Home.route) {
        // Home nav
        composable(route = Route.Home.route) {
            HomeScreen(navController = navController)
        }

        // Encr Nav
        composable(route = Route.Encrypt.route + "/{text}",
                    arguments = listOf(
                        navArgument("text") {
                            type = NavType.StringType
                            defaultValue = ""
                        }
                    )) {
                        EncryptLayout(text = it.arguments?.getString("text"), navController = navController )
        }

        // Decr Nav
        composable(route = Route.Decrypy.route + "/{encode}",
                arguments = listOf(
                    navArgument("encode") {
                        type = NavType.StringType
                        defaultValue = ""
                    }
                )) {
                DecryptScreen(encode = it.arguments?.getString("encode"), navController = navController )
        }

    }
}