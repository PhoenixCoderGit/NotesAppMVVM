package com.felixmamaniquispe.notesappmvvm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.felixmamaniquispe.notesappmvvm.MainViewModel
import com.felixmamaniquispe.notesappmvvm.model.Note
import com.felixmamaniquispe.notesappmvvm.navigation.NavRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainSreen(navController: NavHostController, viewModel: MainViewModel) {

    //val notes = mviewModel.readTest.observeAsState(listOf()).value

    val itemsList = (0..5).toList()
    val itemsIndexedList = listOf("A", "B", "C")

    val notes = viewModel.readAllNotes().observeAsState(listOf()).value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavRoute.Add.route)
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "agregar", tint = Color.White)
            }
        }

    ) {

        /*Column {
            NoteItem(title = "uno", subtitle = "descripcion", navController = navController)
            NoteItem(title = "dos", subtitle = "descripcion", navController = navController)
            NoteItem(title = "tres", subtitle = "descripcion", navController = navController)
            NoteItem(title = "uno", subtitle = "descripcion", navController = navController)
        }*/

        LazyColumn{
            items(notes) { note ->
                NoteItem(note = note, navController = navController)
            }
        }
        /*LazyColumn {
            items(itemsList) {
                Text("Item is $it")
            }

            item {
                Text("Single item")
            }

            itemsIndexed(itemsIndexedList) { index, item ->
                Text("Item at index $index is $item")
            }
        }*/

    }
}

@Composable
fun NoteItem(note: Note, navController:NavHostController){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp,
                horizontal = 24.dp,
            )
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Column (
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = note.subtitle,
                fontSize = 14.sp,
            )

        }

    }
}

/*
fun NoteItem(title:String, subtitle:String,navController:NavHostController){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp,
                horizontal = 24.dp,
            )
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Column (
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle,
                fontSize = 14.sp,
            )

        }

    }
}*/
