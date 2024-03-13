package com.codetutor.simplenavigationexample.components.screens

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
import com.codetutor.simplenavigationexample.viewmodels.SharedViewModel
import com.codetutor.simplenavigationexample.data.Student

@Composable
fun ScreenOne(
    navController: NavController,
    modifier: Modifier = Modifier,
    sharedViewModel: SharedViewModel
) {

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

    val student = Student(
        name = "John Blake",
        age = 25,
        address = "New York, USA",
        contact = "1234567890",
        rollNo = 101,
        standard = 12,
        email = "email.@email.com"
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
                isDialogVisible.value = !isDialogVisible.value
                /*navController.navigate("sample-dialog")*/
            }
            ) {
                Text(text = "Show Pop up dialog")
            }

            Text(text = "Screen One")
            Button(onClick = {
                sharedViewModel.rollNo.value = 101
                navController.navigate("screen-two")
            }
            ) {
                Text(text = "Click for Screen 2")
            }
        }
    }
}