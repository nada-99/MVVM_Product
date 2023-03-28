package com.example.mvvmproduct.favoriteproducts.view

import com.example.mvvmproduct.model.Product

interface OnFavProductClick {
    fun onClick(product: Product)
}