package com.codetutor.simplenavigationexample

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(navController: NavHostController){

    navController.addOnDestinationChangedListener { controller, destination, arguments ->
        // Handle destination change
        Log.d("NavController", "Destination changed to ${destination.route}")
    }

    Scaffold(
        topBar = {
            TopAppBar (
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {

                    Text(text = "CountryInfoApp", style = MaterialTheme.typography.labelLarge)
                },
               navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Home, contentDescription ="ArrowBack")
                    }
                }

            )
        },
    ) { paddingValues ->

        NavHost(navController, startDestination = "screen-one"){
            composable("screen-one"){
                ScreenOne(navController, modifier = Modifier.padding(paddingValues))
            }

            composable("screen-two"){
                ScreenTwo(navController, modifier = Modifier.padding(paddingValues))
            }

            composable("screen-three"){
                ScreenThree(navController, modifier = Modifier.padding(paddingValues))
            }
        }
    }
}