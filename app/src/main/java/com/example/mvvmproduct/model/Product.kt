package com.example.mvvmproduct.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "product")
class Product(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id :Int,

    @ColumnInfo(name = "title")
    var title: String ,

    @ColumnInfo(name = "description")
    var description: String ,

    @ColumnInfo(name = "price")
    var price : Int,

    @ColumnInfo(name = "discountPercentage")
    var discountPercentage :Double,

    @ColumnInfo(name = "rating")
    var rating :Double,

    @ColumnInfo(name = "stock")
    var stock :Int,

    @ColumnInfo(name = "brand")
    var brand: String ,

    @ColumnInfo(name = "category")
    var category: String ,

    @ColumnInfo(name = "thumbnail")
    var thumbnail: String ,
){
    @Ignore
    val images: Array<String>?=null

}