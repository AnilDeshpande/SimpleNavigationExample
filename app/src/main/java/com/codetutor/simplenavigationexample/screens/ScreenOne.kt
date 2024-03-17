package com.codetutor.simplenavigationexample.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.codetutor.simplenavigationexample.components.SampleDialog
import com.codetutor.simplenavigationexample.data.Student
import com.codetutor.simplenavigationexample.viewmodel.SharedViewModel
import kotlinx.serialization.json.Json

@Composable
fun ScreenOne(navController: NavController, modifier: Modifier, sharedViewModel: SharedViewModel) {

    val isDialogVisible = remember {
        mutableStateOf(false)
    }

    when {
        isDialogVisible.value -> {
            SampleDialog(
                onDismissRequest = { isDialogVisible.value = false },
                onConfirmation = { isDialogVisible.value = false },
                dialogTitle = "Sample Dialog",
                dialogText = "This is a sample dialog",
                icon = Icons.Filled.Info
            )
        }
    }

    val sampleStudent = Student(
        name = "Ankit Nahar",
        age = 25,
        rollNo = 101,
        standard = 10,
        address = "123, Main Street, New York",
        contact = "1234567890",
        email = "sampleEmail@email.com"
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = {
                isDialogVisible.value = true
            }) {
                Text(text = "Show Dialog")
            }

            Text(text = "Screen One")
            Button(onClick = {
                sharedViewModel.rollNo.value = 102
                navController.navigate("screen-two")
            }) {
                Text(text = "Click for Screen 2")
            }
        }
    }
}