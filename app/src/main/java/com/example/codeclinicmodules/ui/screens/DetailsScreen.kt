package com.example.codeclinicmodules.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.codeclinicmodules.model.User
import com.example.codeclinicmodules.viewmodel.UserViewModel

@Composable
fun DetailsScreen(
    viewModel: UserViewModel = UserViewModel(),
    navController: NavController, userName: String) {

    val usersViewModelState = viewModel.usersListState.collectAsState()
    val usersState = usersViewModelState.value

    val user = usersState.find { user -> user.name == userName }


    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Row(Modifier.fillMaxWidth()) {
            Text("Name: ", fontWeight = FontWeight.Bold)
            Spacer(Modifier.size(10.dp))
            Text(user?.name ?: "No name")
        }
        Row(Modifier.fillMaxWidth()) {
            Text("Email: ", fontWeight = FontWeight.Bold)
            Spacer(Modifier.size(10.dp))
            Text(user?.email ?: "No email")
        }

        Row(Modifier.fillMaxWidth()) {
            Text("Age: ", fontWeight = FontWeight.Bold)
            Spacer(Modifier.size(10.dp))
            Text(user?.age.toString())
        }

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("GO BACK")
        }

    }
}