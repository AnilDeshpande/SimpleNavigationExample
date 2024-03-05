package com.codetutor.simplenavigationexample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.codetutor.simplenavigationexample.components.AppScaffold

@Composable
fun App(startDestination: String){
    val navController  = rememberNavController()
    
    AppScaffold (startDestination, navController = navController)
}