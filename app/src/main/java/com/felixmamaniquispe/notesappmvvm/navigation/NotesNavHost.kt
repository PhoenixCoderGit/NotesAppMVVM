package com.felixmamaniquispe.notesappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.felixmamaniquispe.notesappmvvm.MainViewModel
import com.felixmamaniquispe.notesappmvvm.screens.AddSreen
import com.felixmamaniquispe.notesappmvvm.screens.MainSreen
import com.felixmamaniquispe.notesappmvvm.screens.NoteSreen
import com.felixmamaniquispe.notesappmvvm.screens.StartSreen

sealed class NavRoute(val route: String){
    object Start: NavRoute("start_screen")
    object Main: NavRoute("main_screen")
    object Add: NavRoute("add_screen")
    object Note: NavRoute("note_screen")
}

@Composable
fun NotesNavHost(mviewModel: MainViewModel) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route){StartSreen(navController = navController, viewModel = mviewModel)}
        composable(NavRoute.Main.route){MainSreen(navController = navController, viewModel = mviewModel)}
        composable(NavRoute.Add.route){AddSreen(navController = navController, viewModel = mviewModel)}
        composable(NavRoute.Note.route){NoteSreen(navController = navController, viewModel = mviewModel)}
    }
}