package com.example.mvvmproduct.allproducts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmproduct.allproducts.viewmodel.AllProductViewModel
import com.example.mvvmproduct.allproducts.viewmodel.AllProductViewModelFactory
import com.example.mvvmproduct.database.ConcreteLocalSource
import com.example.mvvmproduct.databinding.ActivityAllProductsBinding
import com.example.mvvmproduct.model.Product
import com.example.mvvmproduct.model.Repository
import com.example.mvvmproduct.network.ProductClient

class AllProductsActivity : AppCompatActivity(), OnProductListener {

    lateinit var binding: ActivityAllProductsBinding
    lateinit var myAdapter: ProductAdapter
    lateinit var myFactory : AllProductViewModelFactory
    lateinit var viewModel : AllProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myAdapter = ProductAdapter(ArrayList(), this, applicationContext)
        val layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        binding.allproductRecyclerview.layoutManager = layoutManager

        myFactory = AllProductViewModelFactory(Repository.getInstance(ProductClient.getInstance(),
            ConcreteLocalSource(this)))

        viewModel = ViewModelProvider(this,myFactory).get(AllProductViewModel::class.java)
        viewModel.products.observe(this){products ->
            if(products != null){
                myAdapter.setListProduct(products)
                myAdapter.notifyDataSetChanged()
                binding.allproductRecyclerview.adapter = myAdapter
            }
        }
    }

    override fun onClick(product: Product) {
        viewModel.addProduct(product)
    }

}
