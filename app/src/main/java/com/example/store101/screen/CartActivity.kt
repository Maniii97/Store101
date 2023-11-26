package com.example.store101.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.store101.R
import com.example.store101.models.ProductItem
import kotlin.math.floor

class CartActivity : AppCompatActivity() {

    private lateinit var ivEmptyBasket : ImageView
    private lateinit var tvEmpty : TextView
    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var rvBeforeCheckout: RecyclerView
    private lateinit var tvTotPrice: TextView
    private lateinit var tvSavedPrice: TextView
    private lateinit var btnPlaceOrder: AppCompatButton
    private lateinit var productItem: List<ProductItem>
    private lateinit var allProductItems: List<ProductItem>

    companion object{
        var totMrp = 0.0
        var totPrice = 0.0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        totMrp = 0.0
        totPrice = 0.0
        initViewsListeners()
        getProducts()
        setRecyclersViewData()
        this.onFinished(0, 0)

        ivEmptyBasket = findViewById(R.id.ivEmptyBasket)
        tvEmpty = findViewById(R.id.tvEmpty)
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder)
    }

    private fun onFinished(id: Int, qty: Int) {

        totMrp = 0.0
        totPrice = 0.0

        for (i in productItem.indices) {
            if (productItem[i].id == id) {
                totMrp += productItem[i].price * qty
                var price = productItem[i].price * qty
                price = floor(price - (price * productItem[i].discount) / 100)
                totPrice += price
            } else {
                totMrp += productItem[i].price
                var price = productItem[i].price
                price = floor(price - (price * productItem[i].discount) / 100)
                totPrice += price
            }
        }

        tvTotPrice.text = "Total ₹$totPrice"
        val savedPrice = totMrp - totPrice
        tvSavedPrice.text = "Saved Rs $savedPrice"


    }

    private fun setRecyclersViewData() {
        TODO("Not yet implemented")
    }

    private fun getProducts() {
        TODO("Not yet implemented")
    }

    private fun initViewsListeners() {
        cartRecyclerView = findViewById(R.id.cartRecyclerView)
        tvTotPrice = findViewById(R.id.tvTotal)
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder)
        allProductItems = HomeScreenActivity.itemList

        btnCheckout.setOnClickListener {
            if (totPrice != 0.0) {
              //  val intent = Intent(this, CheckoutActivity::class.java)
                intent.putExtra("cost", totPrice.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Sorry Cart Is Empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
    }


}