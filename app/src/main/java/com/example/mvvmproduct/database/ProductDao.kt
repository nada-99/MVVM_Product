package com.example.mvvmproduct.database

import androidx.room.*
import com.example.mvvmproduct.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
//    fun getAllProducts(): Flow<List<Product>>
    suspend fun getAllProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product : Product)

    @Delete
    suspend fun deleteProduct(product: Product)
}