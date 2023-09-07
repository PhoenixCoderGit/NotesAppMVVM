package com.felixmamaniquispe.notesappmvvm.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.felixmamaniquispe.notesappmvvm.MainViewModel
import com.felixmamaniquispe.notesappmvvm.MainViewModelFactory
import com.felixmamaniquispe.notesappmvvm.navigation.NavRoute
import com.felixmamaniquispe.notesappmvvm.utils.TYPE_FIREBASE
import com.felixmamaniquispe.notesappmvvm.utils.TYPE_ROOM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartSreen(navController: NavHostController, viewModel: MainViewModel) {

    // viewModel
    val context = LocalContext.current
    val mviewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))


    Scaffold(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "What will we use?")
            Button(
                onClick = {

                    // viewModel
                    mviewModel.initDatabase(TYPE_ROOM){
                        navController.navigate(route = NavRoute.Main.route)
                    }
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            )
            {
                Text(text = "Room database")
            }
            Button(
                onClick = {

                    // viewModel
                    mviewModel.initDatabase(TYPE_FIREBASE){
                        navController.navigate(route = NavRoute.Main.route)
                    }

                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            )
            {
                Text(text = "Firebase database")
            }
        }

    }



}

