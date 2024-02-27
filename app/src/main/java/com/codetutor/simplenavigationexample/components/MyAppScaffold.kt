package com.codetutor.simplenavigationexample.components

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codetutor.simplenavigationexample.utils.getMyNavGraph
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppScaffold ( startDestination: String, navController: NavHostController) {

    var isBackEnabled = remember {
        mutableStateOf(false)
    }

    navController.addOnDestinationChangedListener { controller,
                                                    destination,
                                                    arguments ->

        Log.i("NavController","Destination: ${destination.route}")
        isBackEnabled.value = destination.route =="screen-one"
    }

    Scaffold(
        topBar = {
            TopAppBar (
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {

                    Text(text = "SimpleAppNavigation", style = MaterialTheme.typography.labelLarge)
                },

                navigationIcon = {

                    var navIcon = if(isBackEnabled.value){
                        Icons.Filled.Home
                    }else{
                        Icons.Filled.ArrowBack
                    }

                    IconButton(onClick = { if(!isBackEnabled.value) { navController.popBackStack() } }) {
                        Icon(imageVector = navIcon, contentDescription = "NavIcon")
                    }
                }
                
            )
        },

    ) { paddingValues ->
        //Add the app scaffold here and pass the padding values to scaffold
        NavHost(navController = navController, graph = getMyNavGraph(startDestination, navController, paddingValues))
    }
}

