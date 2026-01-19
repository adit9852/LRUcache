package com.example.lrucache.repository

import com.example.lrucache.ui.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}


