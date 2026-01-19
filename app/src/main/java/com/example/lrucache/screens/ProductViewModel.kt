package com.example.lrucache.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lrucache.repository.ProductRepository
import com.example.lrucache.repository.ProductRepositoryImpl
import com.example.lrucache.ui.Product
import kotlinx.coroutines.launch


class ProductViewModel : ViewModel() {

    private val productRepository: ProductRepository = ProductRepositoryImpl()

    var isLoading by mutableStateOf(false)

    var products = mutableStateListOf<Product>()

init {
    getProducts()
}



    fun getProducts() {
        viewModelScope.launch {
            isLoading = true
            products.addAll(productRepository.getProducts())
            isLoading = false
        }
    }


}