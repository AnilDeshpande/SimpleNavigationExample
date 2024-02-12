package com.codetutor.simplenavigationexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.codetutor.simplenavigationexample.R
import com.codetutor.simplenavigationexample.composables.ScreenThree
import com.codetutor.simplenavigationexample.composables.ScreenTwo

class FragmentThree(navController: NavController) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                ScreenThree(navController = findNavController())
            }
        }
    }
}