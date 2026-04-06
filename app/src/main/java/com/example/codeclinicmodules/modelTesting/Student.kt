package com.example.codeclinicmodules.modelTesting

data class Student(//#1.- Create a Student module with name, grade and age
    val name: String = "No Name",
    val grade: String = "No Grade",
    val age: Int = 0
)

val student1 = Student("Leo", "A", 28)

val student2 = student1.copy(name = "David") //#2.- Change name without modifying the original

///////////////