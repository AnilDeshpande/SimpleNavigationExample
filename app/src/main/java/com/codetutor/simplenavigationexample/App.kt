package com.codetutor.simplenavigationexample

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.codetutor.simplenavigationexample.components.MyAppScaffold
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo


@Composable
fun App(){
    //NavController
    val navController = rememberNavController()

    navController.addOnDestinationChangedListener { controller,
                                                    destination,
                                                    arguments ->

        Log.i("NavController","Destination: ${destination.route}")
        Log.i("NavController","Controller: ${controller.currentDestination?.route}")

    }

    //NavHost
//    NavHost(navController = navController, startDestination = "screen-one"){
//        navigationGraph(navController = navController)
//    }
    
    NavHost(navController = navController, graph = getMyNavGraph(navController))
}


//NavGraph
fun NavGraphBuilder.navigationGraph(navController: NavController){

    composable("screen-one"){
        ScreenOne(navController)
    }

    composable("screen-two"){
        ScreenTwo(navController)
    }

    composable("screen-three"){
        ScreenThree(navController)
    }
}

fun getMyNavGraph(controller: NavController): NavGraph {
    return controller.createGraph(startDestination = "screen-one"){
        composable("screen-one"){
            ScreenOne(controller)
        }

        composable("screen-two"){
            ScreenTwo(controller)
        }

        composable("screen-three"){
            ScreenThree(controller)
        }
    }
}
