package com.example.mvvmproduct.allproducts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproduct.model.RepositoryInterface

class AllProductViewModelFactory(private val repo: RepositoryInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(AllProductViewModel::class.java)){
            AllProductViewModel(repo) as T
        }else{
            throw IllegalAccessException("ViewModel class not found")
        }
    }
}