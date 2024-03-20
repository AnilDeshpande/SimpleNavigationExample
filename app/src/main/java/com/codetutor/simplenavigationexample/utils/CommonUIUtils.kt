package com.codetutor.simplenavigationexample.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.createGraph
import com.codetutor.simplenavigationexample.components.SampleDialog
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo
import com.codetutor.simplenavigationexample.viewmodel.SharedViewModel

fun getMyNavGraph(
    startDestination: String,
    controller: NavController,
    paddingValues: PaddingValues,
    sharedViewModel: SharedViewModel
): NavGraph {
    return controller.createGraph(startDestination) {
        composable("screen-one") {
            ScreenOne(controller, modifier = Modifier.padding(paddingValues), sharedViewModel)
        }

        composable("screen-two") {
            ScreenTwo(controller, modifier = Modifier.padding(paddingValues), sharedViewModel)
        }

        composable("screen-three") {
            ScreenThree(controller, modifier = Modifier.padding(paddingValues))
        }

        dialog("sample-dialog"){
            SampleDialog(
                onDismissRequest = { controller.popBackStack() },
                onConfirmation = { controller.popBackStack() },
                dialogTitle = "NavGraphDialog",
                dialogText = "This is a dialog triggered from Nav Graph",
                icon = Icons.Filled.Build
            )
        }
    }
}