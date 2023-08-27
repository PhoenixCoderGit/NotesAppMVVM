package com.felixmamaniquispe.notesappmvvm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.felixmamaniquispe.notesappmvvm.navigation.NavRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScrean(navController: NavHostController) {
    Scaffold(
       floatingActionButton = {
           FloatingActionButton(
               onClick = {
                   navController.navigate(NavRoute.Add.route)
               },

           ) {
               Icon(
                   imageVector = Icons.Filled.Add,
                   contentDescription = "Add",
                   tint = Color.Blue
               )
           }
       },
        modifier = Modifier.padding(top = 70.dp)
    ) {

        Column(

        ) {
            NoteItem(title = "uno", subtitle = "sub uno", navController = navController)
            NoteItem(title = "uno", subtitle = "sub uno", navController = navController)
            NoteItem(title = "uno", subtitle = "sub uno", navController = navController)
            NoteItem(title = "uno", subtitle = "sub uno", navController = navController)
        }


    }
}

@Composable
fun NoteItem(title: String, subtitle:String, navController: NavHostController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = subtitle)
        }

    }
}