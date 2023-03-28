package com.example.mvvmproduct.favoriteproducts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproduct.model.RepositoryInterface

class FavProductViewModelFactory (private val repo: RepositoryInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(FavProductViewModel::class.java)){
            FavProductViewModel(repo) as T
        }else{
            throw IllegalAccessException("ViewModel class not found")
        }
    }
}