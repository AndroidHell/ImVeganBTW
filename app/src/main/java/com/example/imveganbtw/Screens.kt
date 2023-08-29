package com.example.imveganbtw

sealed class Screens(val route: String){
    object Home : Screens("home_screen")
    object Language : Screens("language_screen")
    object Notes : Screens("notes_screen")
    object Settings : Screens("settings_screen")
}
