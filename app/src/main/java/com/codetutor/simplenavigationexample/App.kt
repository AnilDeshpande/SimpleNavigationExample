package com.codetutor.simplenavigationexample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo

@Composable
fun App(){
    val navController  = rememberNavController()

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