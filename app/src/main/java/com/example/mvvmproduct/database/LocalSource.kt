package com.example.mvvmproduct.database

import com.example.mvvmproduct.model.Product
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    suspend fun insertProduct(product: Product)
    suspend fun deleteProduct(product: Product)
    suspend fun getStoredProducts() : List<Product>
//    fun getStoredProducts() : Flow<List<Product>>
}