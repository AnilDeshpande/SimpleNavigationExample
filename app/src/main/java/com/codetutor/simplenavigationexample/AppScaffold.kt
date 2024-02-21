package com.codetutor.simplenavigationexample

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(startDestination: String, navController: NavHostController){

    var isBackEnabled = remember { mutableStateOf(false) }

    navController.addOnDestinationChangedListener { controller, destination, arguments ->
        // Handle destination change
        Log.d("NavController", "Destination changed to ${destination.route}")
        isBackEnabled.value = destination.route == "screen-one"
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
                   var navIcon = if (isBackEnabled.value){
                       Icons.Filled.Home
                   }else{
                       Icons.Filled.ArrowBack
                   }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = navIcon, contentDescription ="ArrowBack", Modifier.clickable {
                            if(!isBackEnabled.value){
                                navController.popBackStack()
                            }
                        })
                    }
                }

            )
        },
    ) { paddingValues ->
        NavHost(navController = navController, graph = getMyAppNavGraph(startDestination, navController, paddingValues))
    }
}

fun getMyAppNavGraph(startDestination: String, navController: NavController, paddingValues: PaddingValues): NavGraph {
    return navController.createGraph(startDestination){
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
