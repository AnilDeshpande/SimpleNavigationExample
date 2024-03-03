package com.codetutor.simplenavigationexample.data

import kotlinx.serialization.Serializable

@Serializable
data class Student (val name: String,
                    val age: Int,
                    val rollNo: Int,
                    val standard: Int,
                    val address: String,
                    val contact: String,
                    val email: String)