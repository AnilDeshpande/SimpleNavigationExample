package com.codetutor.simplenavigationexample.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codetutor.simplenavigationexample.data.AppRepository
import com.codetutor.simplenavigationexample.data.Student

class SharedViewModel(repository: AppRepository): ViewModel() {

    val rollNo = MutableLiveData<Int>()


    private val repository by lazy { repository }

    fun getStudent(): Student {
        return repository.getStudent(rollNo = rollNo.value ?: 0)
    }

    fun setStudent(student: Student){
        repository.setStudent(student = student)
    }

}