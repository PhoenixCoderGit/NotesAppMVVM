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
import com.felixmamaniquispe.notesappmvvm.utils.Constants.Screens.ADD_SCREEN
import com.felixmamaniquispe.notesappmvvm.utils.Constants.Screens.MAIN_SCREEN
import com.felixmamaniquispe.notesappmvvm.utils.Constants.Screens.NOTE_SCREEN
import com.felixmamaniquispe.notesappmvvm.utils.Constants.Screens.START_SCREEN

sealed class NavRoute(val route: String){
    object Start: NavRoute(START_SCREEN)
    object Main: NavRoute(MAIN_SCREEN)
    object Add: NavRoute(ADD_SCREEN)
    object Note: NavRoute(NOTE_SCREEN)
}

@Composable
fun NotesNavHost(mviewModel: MainViewModel) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route){StartSreen(navController = navController, viewModel = mviewModel)}
        composable(NavRoute.Main.route){MainSreen(navController = navController, viewModel = mviewModel)}
        composable(NavRoute.Add.route){AddSreen(navController = navController, viewModel = mviewModel)}
        composable(NavRoute.Note.route+"/{id}"){backStackEntry ->
            NoteSreen(navController = navController, viewModel = mviewModel, noteId =  backStackEntry.arguments?.getString("id"))
        }
    }
}