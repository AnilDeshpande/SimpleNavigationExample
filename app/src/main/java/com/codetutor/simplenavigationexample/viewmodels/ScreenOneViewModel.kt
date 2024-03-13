package com.codetutor.simplenavigationexample.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScreenOneViewModel: ViewModel() {

    val isDialogVisible = MutableLiveData<Boolean>()
}