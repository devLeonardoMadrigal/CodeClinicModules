package com.example.codeclinicmodules

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codeclinicmodules.model.User
import com.example.codeclinicmodules.ui.screens.DetailsScreen
import com.example.codeclinicmodules.ui.screens.MainScreen
import com.example.codeclinicmodules.ui.theme.CodeClinicModulesTheme
import com.example.codeclinicmodules.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {

    /*
    User enters details (name, email, age)//DONE
    Data is validated and stored in a data model //MORE OR LESS
    Navigate to a second screen // DONE
    Display structured user data using data classes //DONE
    Maintain clean separation using models//DONE
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeClinicModulesTheme {
                val viewModel: UserViewModel by viewModels()
                val formViewModelState = viewModel.formState.collectAsState()
                val formState = formViewModelState.value
                val usersViewModelState = viewModel.usersListState.collectAsState()
                val usersState = usersViewModelState.value

                val navController = rememberNavController()


                NavHost(navController = navController, startDestination = "MainScreen"){
                    composable(route = "MainScreen", ){
                        MainScreen(
                            viewModel = viewModel,
                            formState = formState,
                            usersState = usersState,
                            navController = navController
                        )
                    }
                    composable(route = "DetailsScreen/{userName}",){ backStackEntry ->

                        val userName = backStackEntry.arguments?.getString("userName")


                        DetailsScreen(
                            navController = navController,
                            viewModel = viewModel,
                            userName = userName ?: "NoUser"
                        )
                    }
                }

            }
        }
    }
}
