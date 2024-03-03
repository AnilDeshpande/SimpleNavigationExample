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
import com.codetutor.simplenavigationexample.data.Student
import kotlinx.serialization.json.Json

@Composable
fun ScreenTwo(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Click for Previous")
        }
        val jsonString = navController.currentBackStackEntry?.arguments?.getString("data") ?: "No Data Available"
        val sampleStudent = Json { prettyPrint = true }.decodeFromString(Student.serializer(), jsonString)
        Text(text = "Screen Two Data received: $sampleStudent")
        Button(onClick = { navController.navigate("screen-three") }) {
            Text(text = "Click for Screen 3")
        }
    }

}