package com.example.mvvmproduct.allproducts.view

import com.example.mvvmproduct.model.Product

interface OnProductListener {
    fun onClick(product: Product)
}