package com.example.store101.recyclerviews

import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.store101.R
import com.example.store101.RemoveItemListener
import com.example.store101.UpdatePrice
import com.example.store101.models.ProductItem
import com.example.store101.screen.CartActivity
import com.example.store101.screen.ProductActivity
import com.example.store101.sharedpreference.PreferenceHelper

class CartListAdapter(

    private var productLists: List<ProductItem>,
    private val removeItemFromCart: RemoveItemListener,
    private val updatePrice: UpdatePrice

) : RecyclerView.Adapter<CartListAdapter.CartListViewHolder>() {

    class CartListViewHolder(
        itemView: View,
        private val removeItemFromCart: RemoveItemListener,
        private val updatePrice: UpdatePrice
    ) : RecyclerView.ViewHolder(itemView){

        private lateinit var tvRvCartListOffer: TextView
        private lateinit var tvProdName: TextView
        private lateinit var tvCartProductQuantity: TextView
        private lateinit var tvCartProdPrice: TextView
        private lateinit var tvCartProdPriceMRP: TextView
        private lateinit var tvQty: TextView
        private lateinit var btnDec: Button
        private lateinit var btnInc: Button
        private lateinit var ivRvCartListImage: ImageView

        init {
            initViews(itemView)
        }

        private fun initViews(itemView: View) {
            tvProdName = itemView.findViewById(R.id.tvProdName)
            tvRvCartListOffer = itemView.findViewById(R.id.tvRvCartListOffer)
            tvCartProductQuantity = itemView.findViewById(R.id.tvCartProductQuantity)
            tvCartProdPrice = itemView.findViewById(R.id.tvCartProdPrice)
            tvCartProdPriceMRP = itemView.findViewById(R.id.tvCartProdPriceMRP)
            tvQty = itemView.findViewById(R.id.tvQty)
            btnDec = itemView.findViewById(R.id.btnDec)
            btnInc = itemView.findViewById(R.id.btnInc)
            ivRvCartListImage = itemView.findViewById(R.id.ivRvCartListImage)
            PreferenceHelper.getSharedPreferences(itemView.context)
        }
        fun setData(productItem: ProductItem) {
            tvProdName.text = productItem.title
            tvCartProdPriceMRP.text = "\u20B9" + productItem.price
            tvCartProdPriceMRP.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            var price = productItem.price
            CartActivity.totMrp += price
            //price = Math.floor(price - price * productItem.offer / 100).toInt()
            CartActivity.totPrice += price
            tvCartProdPrice.text = "\u20B9" + price
            tvRvCartListOffer.text = productItem.discount.toString()
            ivRvCartListImage.setImageResource(productItem.images)
            ivRvCartListImage.setOnClickListener { v ->
                val intent = Intent(v.context, ProductActivity::class.java)
                intent.putExtra("id", productItem.id)
                v.context.startActivity(intent)
            }
            btnInc.setOnClickListener {
                val q = tvQty.text.toString().toInt() + 1
                tvQty.text = q.toString()
                updatePrice.onFinished(productItem.id, q)
            }
            btnDec.setOnClickListener {
                val q = tvQty.text.toString().toInt() - 1
                tvQty.text = q.toString()
                if (q == 0) {
                    removeItemFromCart.removeItemFromCart(productItem.id)
                }
                updatePrice.onFinished(productItem.id, q)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.cart_item,
            parent, false
        )
        return CartListViewHolder(view , removeItemFromCart, updatePrice)
    }

    override fun getItemCount(): Int {
        return productLists.size
    }

    override fun onBindViewHolder(holder: CartListViewHolder, position: Int) {
        val productItem = productLists[position]
        holder.setData(productItem)
    }
}