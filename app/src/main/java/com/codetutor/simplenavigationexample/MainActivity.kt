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

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreeOnePreview() {
    SimpleNavigationExampleTheme {
        ScreenOne()
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenTwoPreview() {
    SimpleNavigationExampleTheme {
        ScreenTwo()
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenThreePreview() {
    SimpleNavigationExampleTheme {
        ScreenThree()
    }
}