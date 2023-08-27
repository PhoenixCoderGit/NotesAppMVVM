package com.felixmamaniquispe.notesappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.felixmamaniquispe.notesappmvvm.screens.AddScrean
import com.felixmamaniquispe.notesappmvvm.screens.MainScrean
import com.felixmamaniquispe.notesappmvvm.screens.NoteScrean
import com.felixmamaniquispe.notesappmvvm.screens.StartScrean

sealed class NavRoute(val route: String){
    object Start: NavRoute("start_screen")
    object Main: NavRoute("main_screen")
    object Add: NavRoute("add_screen")
    object Note: NavRoute("note_screen")
}

@Composable
fun NotesNavHost (){

    // creando un objeto de navegacion
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = NavRoute.Start.route
    ){
        composable(NavRoute.Start.route){
            StartScrean(navController = navController)
        }
        composable(NavRoute.Main.route){
            MainScrean(navController = navController)
        }
        composable(NavRoute.Add.route){
            AddScrean(navController = navController)
        }
        composable(NavRoute.Note.route){
            NoteScrean(navController = navController)
        }
    }

}