package com.example.mvvmproduct.favoriteproducts.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmproduct.databinding.FavRowLayoutBinding
import com.example.mvvmproduct.model.Product

private lateinit var binding : FavRowLayoutBinding

class FavProductAdapter(private var products: List<Product>, var myListener: OnFavProductClick, val context: Context) :
    RecyclerView.Adapter<FavProductAdapter.ViewHolder>() {

    fun setListProduct(values: List<Product?>?) {
        this.products = values as List<Product>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavProductAdapter.ViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = FavRowLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavProductAdapter.ViewHolder, position: Int) {
        val currentProduct = products[position]
        Glide.with(context)
            .load(currentProduct.thumbnail)
            .into(holder.binding.productImageView)
        holder.binding.titleTextView.text = currentProduct.title
        holder.binding.brandTextView.text = currentProduct.brand
        holder.binding.deleteProductBtn.setOnClickListener{
            myListener.onClick(currentProduct)
        }
    }

    override fun getItemCount(): Int =products.size

    inner class ViewHolder(var binding: FavRowLayoutBinding): RecyclerView.ViewHolder(binding.root)

}