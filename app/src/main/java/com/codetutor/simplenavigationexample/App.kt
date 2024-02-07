package com.codetutor.simplenavigationexample

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo

@Composable
fun App(){
    val navController  = rememberNavController()

    navController.addOnDestinationChangedListener { controller, destination, arguments ->
        // Handle destination change
        Log.d("NavController", "Destination changed to ${destination.route}")
    }

    NavHost(navController = navController, startDestination = "screen-one"){
        composable("screen-one"){
            ScreenOne(navController)
        }

        composable("screen-two"){
            ScreenTwo(navController)
        }

        composable("screen-three"){
            ScreenThree(navController)
        }

    }
}