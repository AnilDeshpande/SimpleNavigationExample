package com.codetutor.simplenavigationexample.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.codetutor.simplenavigationexample.SharedViewModel
import com.codetutor.simplenavigationexample.data.Student
import kotlinx.serialization.json.Json

@Composable
fun ScreenOne( navController: NavController, modifier: Modifier = Modifier, viewModel: SharedViewModel) {

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
                viewModel.student.value = student
                navController.navigate("screen-two") }
            ) {
                Text(text = "Click for Screen 2")
            }
        }
    }
}