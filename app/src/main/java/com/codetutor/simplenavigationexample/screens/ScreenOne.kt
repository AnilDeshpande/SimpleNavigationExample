package com.codetutor.simplenavigationexample.screens

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
import com.codetutor.simplenavigationexample.data.Student
import kotlinx.serialization.json.Json

@Composable
fun ScreenOne( navController: NavController, modifier: Modifier) {

    val sampleStudent = Student(
        name = "John Doe",
        age = 25,
        rollNo = 101,
        standard = 10,
        address = "123, Main Street, New York",
        contact = "1234567890",
        email = "sampleEmail@email.com")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val  jsonString = Json{prettyPrint = true}.encodeToString(Student.serializer(), sampleStudent)
            Text(text = "Screen One")
            Button(onClick = { navController.navigate("screen-two/$jsonString") }) {
                Text(text = "Click for Screen 2")
            }
        }
    }
}