package com.example.codeclinicmodules.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.codeclinicmodules.model.User
import com.example.codeclinicmodules.model.UserFormState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class UserViewModel(): ViewModel() {

    private val _usersListState =  MutableStateFlow<List<User>>(emptyList())
    val usersListState: StateFlow<List<User>> = _usersListState.asStateFlow()

    private val _formState =  MutableStateFlow<UserFormState>(UserFormState())
    val formState: StateFlow<UserFormState> = _formState.asStateFlow()

    fun onNameChanged(name: String){
        if (name.isEmpty()) {
            _formState.update {
                it.copy(
                    name = name,
                    nameError = "Name should exist"
                )
            }
        } else{
            _formState.update {
                it.copy(
                    name = name,
                    nameError = null
                )
            }
        }
    }
    fun onEmailChanged(email: String){
        if (email.isEmpty()) {
            _formState.update {
                it.copy(
                    email = email,
                    emailError = "Email should exist"
                )
            }
        } else{
            _formState.update {
                it.copy(
                    email = email,
                    emailError = null
                )
            }
        }
    }

    fun onAgeChanged(age: String){
        if (age.isEmpty()) {
            _formState.update {
                it.copy(
                    age = age,
                    ageError = "Age should exist"
                )
            }
        } else{
            _formState.update {
                it.copy(
                    age = age,
                    ageError = null
                )
            }
        }
    }

    fun onAddButtonPressed(newUser: User){

        if(
            _formState.value.nameError?.isNotEmpty() ?: true
            &&
            _formState.value.emailError?.isNotEmpty() ?: true
            &&
            _formState.value.ageError?.isNotEmpty() ?: true
        ){
            _usersListState.value += newUser

            _formState.update {
                it.copy(
                    name = "",
                    age = "",
                    email = ""
                )
            }

        }


    }

}