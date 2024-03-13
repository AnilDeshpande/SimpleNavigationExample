package com.codetutor.simplenavigationexample.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.createGraph
import com.codetutor.simplenavigationexample.components.SampleDialog
import com.codetutor.simplenavigationexample.viewmodels.SharedViewModel
import com.codetutor.simplenavigationexample.components.screens.ScreenOne
import com.codetutor.simplenavigationexample.components.screens.ScreenThree
import com.codetutor.simplenavigationexample.components.screens.ScreenTwo

fun getMyAppNavGraph(
    startDestination: String,
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: SharedViewModel
): NavGraph {

    return navController.createGraph(startDestination) {
        composable("screen-one") {
            ScreenOne(
                navController,
                modifier = Modifier.padding(paddingValues),
                sharedViewModel = viewModel
            )
        }

        composable("screen-two") {
            ScreenTwo(
                navController,
                modifier = Modifier.padding(paddingValues),
                sharedViewModel = viewModel
            )
        }

        composable("screen-three") {
            ScreenThree(navController, modifier = Modifier.padding(paddingValues))
        }
        
        dialog("sample-dialog") {
            SampleDialog(
                onDismissRequest = { navController.popBackStack() },
                onConfirmation = { navController.popBackStack() },
                dialogTitle = "Sample Dialog",
                dialogText = "This is a sample dialog",
                icon = Icons.Filled.Info
            )
        }
    }
}