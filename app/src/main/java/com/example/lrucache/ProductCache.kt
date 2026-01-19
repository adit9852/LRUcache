package com.example.lrucache

import android.util.LruCache
import com.example.lrucache.ProductCache.Keys.ProductsKey
import com.example.lrucache.ui.Product

object ProductCache {


    object Keys {
        const val ProductsKey = "products"
    }


    private val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
    private val cacheSize = maxMemory / 8

    private val cache = LruCache<String, List<Product>>(cacheSize)


    fun saveProducts(products: List<Product>) {
        cache.put(ProductsKey, products)
    }

    fun getProducts(): List<Product>? {
        return cache.get(ProductsKey)
    }
}