package com.codetutor.simplenavigationexample.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppScaffold () {
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
            )
        },
    ) { paddingValues ->
        //Add the app scaffold here and pass the padding values to scaffold

    }
}