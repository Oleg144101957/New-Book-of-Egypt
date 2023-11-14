package book.egypt.advanture.ui.theme.destinations

sealed class Displays(val destination: String){

    object Loading : Displays("loading")
    object Launcher : Displays("launcher")
    object Playground : Displays("playground")
    object Settings : Displays("settings")
}