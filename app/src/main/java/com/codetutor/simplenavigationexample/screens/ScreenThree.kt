package com.codetutor.simplenavigationexample.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ScreenThree( navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Click for Previous")
        }
        Text(text = "Screen Three")
        Button(onClick = { navController.popBackStack(navController.graph.startDestinationId, inclusive = false) }) {
            Text(text = "Click for Home")
        }
    }
}