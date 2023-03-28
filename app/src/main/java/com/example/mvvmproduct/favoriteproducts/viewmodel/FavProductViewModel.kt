package com.example.mvvmproduct.favoriteproducts.viewmodel

import androidx.lifecycle.*
import com.example.mvvmproduct.model.Product
import com.example.mvvmproduct.model.RepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FavProductViewModel (private val repo: RepositoryInterface) : ViewModel() {

    //private var productMutableList : MutableLiveData<List<Product>> = MutableLiveData<List<Product>>()
    private var productMutableList = MutableStateFlow<List<Product>>(ArrayList())
    val products : StateFlow<List<Product>> = productMutableList

    init {
        getFavProducts()
    }

    fun getFavProducts(){
        viewModelScope.launch(Dispatchers.IO) {
            //productMutableList.postValue(repo.getFavProducts())
            productMutableList.value = repo.getFavProducts()
        }
    }

    fun deleteProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteAProduct(product)
            getFavProducts()
        }
    }

//    fun getFavProducts(){
//        viewModelScope.launch(Dispatchers.IO) {
//            //productMutableList.postValue(repo.getFavProducts())
//            repo.getFavProducts().collect{
//                productMutableList.postValue(it)
//            }
//        }
//    }


}