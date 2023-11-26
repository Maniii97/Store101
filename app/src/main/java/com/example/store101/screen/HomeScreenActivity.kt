package com.example.store101.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.store101.R
import com.example.store101.models.ProductItem
import com.example.store101.recyclerviews.BestDealAdapter

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var rvBestDeal: RecyclerView
    private lateinit var tvAllCategory: TextView
    private lateinit var ibOil: ImageButton
    private lateinit var ibMeat: ImageButton
    private lateinit var ibTea: ImageButton
    private lateinit var ibFresho: ImageButton
    private lateinit var ibDairy: ImageButton
    private lateinit var ibSnacks: ImageButton
    private lateinit var btnCart: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        rvBestDeal = findViewById(R.id.rvBestDeals)
        tvAllCategory = findViewById(R.id.tvAllCategory)
        ibOil = findViewById(R.id.ibOil)
        ibMeat = findViewById(R.id.ibMeat)
        ibTea = findViewById(R.id.ibTea)
        ibFresho = findViewById(R.id.ibFresho)
        ibDairy = findViewById(R.id.ibDairy)
        ibSnacks = findViewById(R.id.ibSnacks)

        btnCart = findViewById(R.id.btnCart)

        btnCart.setOnClickListener {
            openCart()
        }

        tvAllCategory.setOnClickListener {
            onAllCategoryClicked()
        }

        onImageButtonClicked()

        val itemList = getItemList()
        val adapter = BestDealAdapter(itemList)
        rvBestDeal.adapter = adapter
        rvBestDeal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun onAllCategoryClicked() {
        Intent(this, AllCategoriesActivity::class.java).also {
            startActivity(it)
        }
    }

    private fun onImageButtonClicked() {
        ibDairy.setOnClickListener {
            toastIB()
        }
        ibFresho.setOnClickListener {
            toastIB()
        }
        ibMeat.setOnClickListener {
            toastIB()
        }
        ibOil.setOnClickListener {
            toastIB()
        }
        ibSnacks.setOnClickListener {
            toastIB()
        }
        ibTea.setOnClickListener {
            toastIB()
        }
    }

    private fun toastIB() {
        Toast.makeText(this, "Currently not linked to backend", Toast.LENGTH_LONG).show()
    }

    private fun openCart() {
        Intent(this, CartActivity::class.java).also {
            startActivity(it)
        }
    }

    private fun getItemList(): MutableList<ProductItem> {

        // in case of api call, we will get the list of products from the api
        return mutableListOf(
            ProductItem(
                1,
                R.drawable.vegetables,
                "Apple",
                "fruits",
                120.0,
                10,
                true,
                "Fresh Apples directly from the farm",
                true
            ),
            ProductItem(
                2,
                R.drawable.mango,
                "Apple",
                "fruits",
                120.0,
                10,
                true,
                "Fresh Apples directly from the farm",
                true
            ),
            ProductItem(
                3,
                R.drawable.mango,
                "Mango",
                "fruits",
                120.0,
                10,
                true,
                "Fresh Mangoes directly from the farm",
                true
            )

        )

    }


}