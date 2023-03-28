package com.example.mvvmproduct.allproducts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmproduct.model.MyResponse
import com.example.mvvmproduct.model.Product
import com.example.mvvmproduct.model.RepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllProductViewModel (private val repo: RepositoryInterface) : ViewModel() {

    private var productMutableList : MutableLiveData<List<Product>> = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>> = productMutableList

    init {
        getAllProducts()
    }

    fun getAllProducts(){
        viewModelScope.launch(Dispatchers.Default) {
            repo.getAllProductsNetwork().collect{
                productMutableList.postValue(it.products)
            }
            //productMutableList.postValue(repo.getAllProductsNetwork().products)
        }
    }

    fun addProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertAProduct(product)
            getAllProducts()
        }
    }

}