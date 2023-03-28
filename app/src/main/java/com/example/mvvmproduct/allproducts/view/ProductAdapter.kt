package com.example.mvvmproduct.allproducts.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmproduct.databinding.ProductRowLayoutBinding
import com.example.mvvmproduct.model.Product

private lateinit var binding : ProductRowLayoutBinding

class ProductAdapter(private var products: List<Product>, var myListener: OnProductListener, val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    fun setListProduct(values: List<Product?>?) {
        this.products = values as List<Product>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ProductRowLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = products[position]
        Glide.with(context)
            .load(currentProduct.thumbnail)
            .into(holder.binding.productImageView)
        holder.binding.titleTextView.text = currentProduct.title
        holder.binding.brandTextView.text = currentProduct.brand
        holder.binding.addProductBtn.setOnClickListener{
            myListener.onClick(currentProduct)
        }
    }

    override fun getItemCount(): Int =products.size

    inner class ViewHolder(var binding: ProductRowLayoutBinding): RecyclerView.ViewHolder(binding.root)

}