package com.codetutor.simplenavigationexample.components.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.codetutor.simplenavigationexample.viewmodels.SharedViewModel
import com.codetutor.simplenavigationexample.data.Student

@Composable
fun ScreenOne(navController: NavController,
              modifier: Modifier = Modifier,
              sharedViewModel: SharedViewModel
) {


    val student = Student(name = "John Blake",
                        age = 25,
                        address = "New York, USA",
                        contact = "1234567890",
                        rollNo = 101,
                        standard = 12,
                        email = "email.@email.com")


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Screen One")
            Button(onClick = {
                sharedViewModel.rollNo.value = 101
                navController.navigate("screen-two") }
            ) {
                Text(text = "Click for Screen 2")
            }
        }
    }
}