package com.example.mvvmproduct.model

import com.example.mvvmproduct.database.LocalSource
import com.example.mvvmproduct.network.RemoteSource
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface  {

//    suspend fun getAllProductsNetwork() : MyResponse
    suspend fun getFavProducts() : List<Product>
suspend fun getAllProductsNetwork() : Flow<MyResponse>
//    suspend fun getFavProducts() : Flow<List<Product>>
    suspend fun insertAProduct(product: Product)
    suspend fun deleteAProduct(product: Product)
}