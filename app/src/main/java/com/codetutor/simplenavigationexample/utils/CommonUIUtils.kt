package com.codetutor.simplenavigationexample.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo

fun getMyNavGraph(controller: NavController, paddingValues: PaddingValues): NavGraph {
    return controller.createGraph(startDestination = "screen-one"){
        composable("screen-one"){
            ScreenOne(controller, modifier = Modifier.padding(paddingValues))
        }

        composable("screen-two"){
            ScreenTwo(controller, modifier = Modifier.padding(paddingValues))
        }

        composable("screen-three"){
            ScreenThree(controller, modifier = Modifier.padding(paddingValues))
        }
    }
}

//NavGraph
fun NavGraphBuilder.navigationGraph(navController: NavController, paddingValues: PaddingValues){

    composable("screen-one"){
        ScreenOne(navController, modifier = Modifier.padding(paddingValues))
    }

    composable("screen-two"){
        ScreenTwo(navController, modifier = Modifier.padding(paddingValues))
    }

    composable("screen-three"){
        ScreenThree(navController, modifier = Modifier.padding(paddingValues))
    }
}