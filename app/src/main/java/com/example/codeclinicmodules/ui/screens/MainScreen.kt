package com.example.codeclinicmodules.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.codeclinicmodules.model.User
import com.example.codeclinicmodules.model.UserFormState
import com.example.codeclinicmodules.viewmodel.UserViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: UserViewModel = UserViewModel(),
    formState: UserFormState,
    usersState: List<User>
               ) {

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        TextField(
            value = formState.name,
            onValueChange = {
                viewModel.onNameChanged(it)
            },
            label = {Text("Name")}
        )
        Spacer(Modifier.size(24.dp))

        TextField(
            value = formState.email,
            onValueChange = {
                viewModel.onEmailChanged(it)
            },
                    label = {Text("Email")}
        )
        Spacer(Modifier.size(24.dp))
        TextField(
            value = formState.age,
            onValueChange = {
                viewModel.onAgeChanged(it)
            },
            label = {Text("Age")}
        )
        Spacer(Modifier.size(24.dp))

        Button(onClick = {
            viewModel.onAddButtonPressed(
                newUser = User(
                    name = formState.name,
                    email = formState.email,
                    age = formState.age.toInt()
                )
            )
        }) {
            Text("Add")
        }


        Spacer(Modifier.size(24.dp))

        LazyColumn() {
            items(items = usersState) { user ->
                Button(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    onClick = {
                    navController.navigate("DetailsScreen/${user.name}")
                }) {
                    Text("${user.name}")
                }

            }
        }



    }

}