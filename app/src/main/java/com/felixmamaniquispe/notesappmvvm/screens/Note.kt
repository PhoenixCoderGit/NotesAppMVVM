package com.felixmamaniquispe.notesappmvvm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.felixmamaniquispe.notesappmvvm.MainViewModel
import com.felixmamaniquispe.notesappmvvm.model.Note
import com.felixmamaniquispe.notesappmvvm.navigation.NavRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteSreen(navController: NavHostController, viewModel: MainViewModel, noteId: String?) {
    val coroutineScope = rememberCoroutineScope()
    val notes = viewModel.readAllNotes().observeAsState(listOf()).value
    val note = notes.firstOrNull{it.id==noteId?.toInt()}?: Note(title = "none", subtitle = "none")
    var title by remember { mutableStateOf("") }
    var subtitle by remember{ mutableStateOf("") }
    /*

    val bottomSheetState = rememberModalBottomSheetState()



    ModalBottomSheet(
        onDismissRequest = {

        },
        sheetState = bottomSheetState,
        content = {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 32.dp)
                ) {
                    Text(text = "editar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = title,
                        onValueChange = {title = it},
                        label = { Text(text = "titulo")},
                        isError = title.isEmpty()
                    )
                    OutlinedTextField(
                        value = subtitle,
                        onValueChange = {subtitle = it},
                        label = { Text(text = "subtitulo")},
                        isError = subtitle.isEmpty()
                    )
                    Button(
                        modifier = Modifier.padding(top = 16.dp),
                        onClick = {
                            *//*coroutineScope.launch{
                                title = note.title
                                subtitle = note.subtitle
                                bottomSheetState.show()
                            }*//*
                        }
                    ) {
                        Text(text = "Acturalizar")
                    }
                }
            }
        }
    )*/

    /*Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = note.title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 32.dp)
                    )
                    Text(
                        text = note.subtitle,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Button(onClick = {

                }) {
                    Text(text = "UPDATE")
                }

                Button(onClick = {

                }) {
                    Text(text = "DELETE")
                }
            }

            Button(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate(NavRoute.Main.route)
            }) {
                Text(text = "NAV back")
            }

        }
    }*/


    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        val modalBottomSheetState = rememberModalBottomSheetState()
        ModalBottomSheet(
            onDismissRequest = { showSheet=false },
            sheetState = modalBottomSheetState,
            dragHandle = { BottomSheetDefaults.DragHandle() },
        ) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 32.dp)
                ) {
                    Text(text = "editar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = title,
                        onValueChange = {title = it},
                        label = { Text(text = "titulo")},
                        isError = title.isEmpty()
                    )
                    OutlinedTextField(
                        value = subtitle,
                        onValueChange = {subtitle = it},
                        label = { Text(text = "subtitulo")},
                        isError = subtitle.isEmpty()
                    )
                    Button(
                        modifier = Modifier.padding(top = 16.dp),
                        onClick = {
                            /*coroutineScope.launch{
                                title = note.title
                                subtitle = note.subtitle
                                showSheet = true
                                //bottomSheetState.show()
                            }*/
                            viewModel.updateNote(
                                note = Note(id=note.id,title = title, subtitle = subtitle)
                            ){
                                navController.navigate(NavRoute.Main.route)
                            }
                        }
                    ){
                        Text(text = "Acturalizar")
                    }


                }
            }
        }

    }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 32.dp)
            )
            Text(
                text = note.subtitle,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(top = 16.dp)
            )

            Button(onClick = {
               showSheet = true
            }) {
                Text(text = "Actualizar")
            }
            Button(onClick = {
                viewModel.deleteNote(note=note){
                    navController.navigate(NavRoute.Main.route)
                }

            }) {
                Text(text = "Eliminar")
            }
        }
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(title:String,note:Note,coroutineScope:CoroutineScope,onDismiss: () -> Unit) {

    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 32.dp)
            ) {
                Text(text = "editar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                OutlinedTextField(
                    value = title,
                    onValueChange = {},
                    label = { Text(text = "titulo")},
                    isError = title.isEmpty()
                )
                Button(
                    modifier = Modifier.padding(top = 16.dp),
                    onClick = {
                        coroutineScope.launch{
                            //title = note.title
                            //bottomSheetState.show()
                        }
                    }
                ){
                    Text(text = "Acturalizar")
                }
                Button(
                    modifier = Modifier.padding(top = 16.dp),
                    onClick = {
                        coroutineScope.launch{
                            //title = note.title
                            //bottomSheetState.show()
                        }
                    }
                ){
                    Text(text = "Eliminar")
                }
            }
        }
    }
}

