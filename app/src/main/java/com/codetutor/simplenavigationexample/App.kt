package com.codetutor.simplenavigationexample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App(){
    val navController  = rememberNavController()
    
    AppScaffold(navController = navController)
}