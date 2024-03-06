package com.codetutor.simplenavigationexample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.codetutor.simplenavigationexample.components.AppScaffold
import com.codetutor.simplenavigationexample.viewmodels.SharedViewModel

@Composable
fun App(startDestination: String) {
    val navController = rememberNavController()
    val sharedViewModel = remember { SharedViewModel() }
    AppScaffold(startDestination, navController = navController, sharedViewModel = sharedViewModel)
}