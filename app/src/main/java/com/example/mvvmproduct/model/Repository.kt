package com.example.mvvmproduct.model

import com.example.mvvmproduct.database.LocalSource
import com.example.mvvmproduct.network.ProductClient
import com.example.mvvmproduct.network.RemoteSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository private constructor(
    var remoteSource: RemoteSource, var localSource: LocalSource) : RepositoryInterface {

    companion object{
        private var instance : Repository? = null
        fun getInstance(remoteSource: RemoteSource, localSource: LocalSource) : Repository {
            return instance?: synchronized(this){
                val temp = Repository(remoteSource , localSource)
                instance = temp
                temp
            }
        }
    }

    override suspend fun getAllProductsNetwork(): Flow<MyResponse> {
        return flowOf(remoteSource.getProductsFromNetworks())
    }
//    override suspend fun getAllProductsNetwork(): MyResponse {
//        return remoteSource.getProductsFromNetworks()
//    }

//    override suspend fun getFavProducts(): Flow<List<Product>> {
//        return localSource.getStoredProducts()
//    }

    override suspend fun getFavProducts(): List<Product> {
        return localSource.getStoredProducts()
    }

    override suspend fun insertAProduct(product: Product) {
        return localSource.insertProduct(product)
    }

    override suspend fun deleteAProduct(product: Product) {
        return localSource.deleteProduct(product)
    }

}