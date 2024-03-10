package com.codetutor.simplenavigationexample.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.codetutor.simplenavigationexample.MyApplication
import com.codetutor.simplenavigationexample.data.Student
import com.codetutor.simplenavigationexample.viewmodel.SharedViewModel
import kotlinx.serialization.json.Json

@Composable
fun ScreenTwo(navController: NavController, modifier: Modifier = Modifier, sharedViewModel: SharedViewModel) {
    val context = LocalContext.current
    val myApplication = context.applicationContext as MyApplication


    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Click for Previous")
        }

        Text(text = "Screen Two Data received: ${sharedViewModel.getStudent()}")
        Button(onClick = { navController.navigate("screen-three") }) {
            Text(text = "Click for Screen 3")
        }
    }

}