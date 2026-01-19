package com.example.lrucache.repository

import android.util.Log
import com.example.lrucache.ProductCache
import com.example.lrucache.ui.Product
import com.example.lrucache.ui.ProductApi

class ProductRepositoryImpl : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return try {
            val cachedProducts = ProductCache.getProducts()
            if (cachedProducts == null) {
                Log.d("test", "Fetching products from API")
                ProductCache.saveProducts(ProductApi.instance.getProducts())}
                else {
                    Log.d("test", "Fetching products from cache")

                }

            ProductCache.getProducts() ?: emptyList()


        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

}