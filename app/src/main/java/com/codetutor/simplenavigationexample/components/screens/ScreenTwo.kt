package com.codetutor.simplenavigationexample.components.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.codetutor.simplenavigationexample.viewmodels.SharedViewModel

@Composable
fun ScreenTwo(navController: NavController,
              modifier: Modifier = Modifier,
              sharedViewModel: SharedViewModel
) {

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Click for Previous")
        }

        Text(text = "Screen Two: Data ${sharedViewModel.student.value}")
        Button(onClick = { navController.navigate("screen-three") }) {
            Text(text = "Click for Screen 3")
        }
    }

}