package com.codetutor.simplenavigationexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codetutor.simplenavigationexample.data.AppRepository
import com.codetutor.simplenavigationexample.data.Student

class SharedViewModel: ViewModel() {
    val student = MutableLiveData<Student>()
}