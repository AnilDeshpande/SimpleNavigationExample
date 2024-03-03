package com.codetutor.simplenavigationexample.screens

import android.support.v4.os.IResultReceiver.Stub
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.codetutor.simplenavigationexample.MyApplication
import com.codetutor.simplenavigationexample.data.Student

@Composable
fun ScreenTwo(navController: NavController, modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val myApplication = context.applicationContext as MyApplication

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Click for Previous")
        }
        val stringRollNo = navController.currentBackStackEntry?.arguments?.getString("rollNo")
        val rollNo = stringRollNo?.toInt() ?: 0
        val student = myApplication.getRepository()?.getStudent(rollNo)

        Text(text = "Screen Two: Data $student")
        Button(onClick = { navController.navigate("screen-three") }) {
            Text(text = "Click for Screen 3")
        }
    }

}