package com.example.codeclinicmodules.modelTesting

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val userAddress: UserAddress,
    val isLoading: uiStates
)


data class UserAddress(
    val streetName: String,
    val streetNumber: Int
)


data class uiStates(
    val Loading: Boolean,
)

//sealed interface uiState{
//    object Loading: uiState
//    data class Success(val result: List<Product>): uiState
//    data class Error(val message: String): uiState
//}




/*
{
  "id": 1,
  "title": "iPhone",
  "price": 999
}
 */