package book.egypt.advanture.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import book.egypt.advanture.EgyptViewModel
import book.egypt.advanture.ui.theme.destinations.Displays
import book.egypt.advanture.ui.theme.screens.LauncherDisplay
import book.egypt.advanture.ui.theme.screens.LoadingDisplay
import book.egypt.advanture.ui.theme.screens.PlaygroundDisplay
import book.egypt.advanture.ui.theme.screens.SettingsDisplay


@Composable
fun NavigationBlock(egyptViewModel: EgyptViewModel){

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Displays.Loading.destination){
        composable(route = Displays.Loading.destination){
            LoadingDisplay(navHostController, egyptViewModel)
        }

        composable(route = Displays.Launcher.destination){
            LauncherDisplay(navHostController)
        }

        composable(route = Displays.Playground.destination){
            PlaygroundDisplay(navHostController)
        }

        composable(route = Displays.Settings.destination){
            SettingsDisplay()
        }
    }
}