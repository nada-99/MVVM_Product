package com.example.mvvmproduct.database

import android.content.Context
import com.example.mvvmproduct.model.Product
import kotlinx.coroutines.flow.Flow

class ConcreteLocalSource(context: Context) : LocalSource {

    private val productDao : ProductDao by lazy {
        val db : ProductDataBase = ProductDataBase.getInstance(context)
        db.getProductDao()
    }

    override suspend fun insertProduct(product: Product){
        productDao.insertProduct(product)
    }

    override suspend fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }

//    override fun getStoredProducts(): Flow<List<Product>> {
//        return productDao.getAllProducts()
//    }

    override suspend fun getStoredProducts(): List<Product> {
        return productDao.getAllProducts()
    }
}