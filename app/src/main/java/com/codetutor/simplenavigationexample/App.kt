package com.codetutor.simplenavigationexample

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.codetutor.simplenavigationexample.components.MyAppScaffold
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo
import com.codetutor.simplenavigationexample.viewmodel.SharedViewModel


@Composable
fun App(startDestination: String = "screen-one"){
    //NavController
    val navController = rememberNavController()
    val sharedViewModel = remember {
        SharedViewModel()
    }
    MyAppScaffold(startDestination, navController, sharedViewModel)
}



