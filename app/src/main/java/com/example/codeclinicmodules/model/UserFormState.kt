package com.example.codeclinicmodules.model

data class UserFormState(
    val name: String = "",
    val email: String = "",
    val age: String = "",
    val nameError: String? = null,
    val emailError: String? = null,
    val ageError: String? = null
)