package com.codetutor.simplenavigationexample

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo


@Composable
fun App(){
    //NavController
    val navController = rememberNavController()

    //NavHost
    NavHost(navController = navController, startDestination = "screen-one"){
        navigationGraph(navController = navController)
    }
}





//NavGraph
fun NavGraphBuilder.navigationGraph(navController: NavController){

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
