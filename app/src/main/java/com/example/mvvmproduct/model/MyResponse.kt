package com.example.mvvmproduct.model

data class MyResponse(var products : List<Product>, var total : Int, var limit : Int, var skip : Int) {
}