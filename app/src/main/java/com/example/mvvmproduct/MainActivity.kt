package com.example.mvvmproduct

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmproduct.allproducts.view.AllProductsActivity
import com.example.mvvmproduct.databinding.ActivityMainBinding
import com.example.mvvmproduct.favoriteproducts.view.FavProductsActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.allProductBtn.setOnClickListener {
            val intent = Intent(this, AllProductsActivity::class.java)
            startActivity(intent)
        }

        binding.favProductBtn.setOnClickListener {
            val intent = Intent(this, FavProductsActivity::class.java)
            startActivity(intent)
        }

        binding.exitBtn.setOnClickListener {
            finish()
        }
    }
}