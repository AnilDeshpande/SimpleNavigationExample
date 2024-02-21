package com.codetutor.simplenavigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.codetutor.simplenavigationexample.screens.ScreenOne
import com.codetutor.simplenavigationexample.screens.ScreenThree
import com.codetutor.simplenavigationexample.screens.ScreenTwo
import com.codetutor.simplenavigationexample.ui.theme.SimpleNavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNavigationExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(startDestination = "screen-one")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreeOnePreview() {
    val navController  = rememberNavController()
    SimpleNavigationExampleTheme {
        ScreenOne(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenTwoPreview() {
    val navController  = rememberNavController()
    SimpleNavigationExampleTheme {
        ScreenTwo(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenThreePreview() {
    val navController  = rememberNavController()
    SimpleNavigationExampleTheme {
        ScreenThree(navController)
    }
}