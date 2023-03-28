package com.example.mvvmproduct.network

import com.example.mvvmproduct.model.MyResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ProductService {
    @GET("products")
//    fun getAllProducts(): Flow<MyResponse>
    suspend fun getAllProducts(): MyResponse
}