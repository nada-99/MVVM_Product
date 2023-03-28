package com.example.mvvmproduct.network

import com.example.mvvmproduct.model.MyResponse
import kotlinx.coroutines.flow.Flow

interface RemoteSource {
    suspend fun getProductsFromNetworks() : MyResponse
//    fun getProductsFromNetworks() : Flow<MyResponse>
}