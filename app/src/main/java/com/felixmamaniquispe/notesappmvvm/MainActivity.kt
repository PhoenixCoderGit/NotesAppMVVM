package com.felixmamaniquispe.notesappmvvm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felixmamaniquispe.notesappmvvm.navigation.NotesNavHost
import com.felixmamaniquispe.notesappmvvm.ui.theme.NotesAppMVVMTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppMVVMTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(

                    topBar = {
                        TopAppBar(

                            navigationIcon = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Menu Icon"
                                    )
                                }
                            },
                            title = {
                                Text(text = "Notas App")
                            },
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                            ),

                        )
                    },

                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        )
                        {
                            NotesNavHost()
                        }
                    },

                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotesAppMVVMTheme {

    }
}