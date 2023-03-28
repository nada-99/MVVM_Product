package com.example.mvvmproduct.favoriteproducts.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmproduct.allproducts.viewmodel.AllProductViewModel
import com.example.mvvmproduct.allproducts.viewmodel.AllProductViewModelFactory
import com.example.mvvmproduct.database.ConcreteLocalSource
import com.example.mvvmproduct.database.ProductDao
import com.example.mvvmproduct.database.ProductDataBase
import com.example.mvvmproduct.databinding.ActivityFavProductsBinding
import com.example.mvvmproduct.favoriteproducts.viewmodel.FavProductViewModel
import com.example.mvvmproduct.favoriteproducts.viewmodel.FavProductViewModelFactory
import com.example.mvvmproduct.model.Product
import com.example.mvvmproduct.model.Repository
import com.example.mvvmproduct.network.ProductClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavProductsActivity : AppCompatActivity(), OnFavProductClick {

    lateinit var binding: ActivityFavProductsBinding
    lateinit var myAdapter: FavProductAdapter
    lateinit var favFactory : FavProductViewModelFactory
    lateinit var viewModel : FavProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myAdapter = FavProductAdapter(ArrayList(), this, applicationContext)
        val layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        binding.favproductRecyclerview.layoutManager = layoutManager

        favFactory = FavProductViewModelFactory(
            Repository.getInstance(ProductClient.getInstance(),
            ConcreteLocalSource(this)))

        viewModel = ViewModelProvider(this,favFactory).get(FavProductViewModel::class.java)
//        viewModel.products.observe(this){products ->
//            if(products != null){
//                myAdapter.setListProduct(products)
//                myAdapter.notifyDataSetChanged()
//                binding.favproductRecyclerview.adapter = myAdapter
//            }
//        }
        lifecycleScope.launch {
            viewModel.products.collectLatest { products ->
                myAdapter.setListProduct(products)
                myAdapter.notifyDataSetChanged()
                binding.favproductRecyclerview.adapter = myAdapter
            }
        }

    }

    override fun onClick(product: Product) {
        viewModel.deleteProduct(product)
    }
}