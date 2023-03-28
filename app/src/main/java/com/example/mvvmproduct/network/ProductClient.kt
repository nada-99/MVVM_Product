package com.example.mvvmproduct.network

import com.example.mvvmproduct.model.MyResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.create

class ProductClient private constructor() : RemoteSource{

    val productService : ProductService by lazy {
        RetrofitHelper.getInstance().create(ProductService::class.java)
    }

//    override fun getProductsFromNetworks(): Flow<MyResponse> {
//        return productService.getAllProducts()
//    }


    override suspend fun getProductsFromNetworks(): MyResponse {
        return productService.getAllProducts()
    }

    companion object{
        private var instance : ProductClient? = null
        fun getInstance() : ProductClient{
            return instance?: synchronized(this){
                val temp = ProductClient()
                instance = temp
                temp
            }
        }
    }
}