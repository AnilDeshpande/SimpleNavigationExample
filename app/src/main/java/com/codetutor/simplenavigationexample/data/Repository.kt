package com.codetutor.simplenavigationexample.data

interface Repository {
    fun getStudent(rollNo: Int): Student
    fun setStudent(student: Student)
}