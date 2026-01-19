package com.example.lrucache.repository

import com.example.lrucache.ui.Product
import com.example.lrucache.ui.ProductApi

class ProductRepositoryImpl : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return try {
            return ProductApi.instance.getProducts()


        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

}