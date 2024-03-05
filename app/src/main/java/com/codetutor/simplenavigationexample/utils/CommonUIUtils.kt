package com.codetutor.simplenavigationexample.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo

fun getMyAppNavGraph(startDestination: String, navController: NavController, paddingValues: PaddingValues): NavGraph {
    return navController.createGraph(startDestination){
        composable("screen-one"){
            ScreenOne(navController, modifier = Modifier.padding(paddingValues))
        }

        composable("screen-two/{rollNo}"){
            val stringRollNo = it.arguments?.getString("rollNo") ?: "0"
            val data = stringRollNo.toInt()
            navController.currentBackStackEntry?.arguments?.apply {
                putInt("rollNo",data)
            }
            ScreenTwo(navController, modifier = Modifier.padding(paddingValues))
        }

        composable("screen-three"){
            ScreenThree(navController, modifier = Modifier.padding(paddingValues))
        }
    }
}