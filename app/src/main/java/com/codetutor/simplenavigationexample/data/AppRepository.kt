package com.codetutor.simplenavigationexample.data

class AppRepository: Repository {
    private var studentList = mutableListOf<Student>(
        Student(name = "John Blake",
                age = 25,
                address = "New York, USA",
                contact = "1234567890",
                rollNo = 101,
                standard = 12,
                email = "email.@email.com"),
        Student(name = "Kangana Sharma",
                age = 25,
                address = "New York, USA",
                contact = "1234567890",
                rollNo = 102,
                standard = 12,
                email = "email.@email.com"),
        Student(name = "Ankit Srivastav",
                age = 25,
                address = "New York, USA",
                contact = "1234567890",
                rollNo = 103,
                standard = 12,
                email = "email.@email.com"),
        Student(name = "Mohammad Shakir",
                age = 25,
                address = "New York, USA",
                contact = "1234567890",
                rollNo = 104,
                standard = 12,
                email = "email.@email.com"),
    )

    override fun getStudent(rollNo: Int): Student {
        return studentList.find { it.rollNo == rollNo } ?: Student(name = "No Student Found",
                                                                 age = 0,
                                                                 address = "No Address",
                                                                 contact = "No Contact",
                                                                 rollNo = 0,
                                                                 standard = 0,
                                                                 email = "No Email")
    }

    override fun setStudent(student: Student) {
        studentList.add(student)
    }

}