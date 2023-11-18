package com.example.store101.recyclerviews

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.store101.R
import com.example.store101.auth.LoginActivity
import com.example.store101.models.ProductItem
import com.example.store101.screen.HomeScreenActivity
import com.example.store101.sharedpreference.PreferenceHelper

class BestDealAdapter(private var productList: MutableList<ProductItem>) : RecyclerView.Adapter<BestDealAdapter.BestDealViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestDealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_best_deal,parent,false)
        return BestDealViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: BestDealViewHolder, position: Int) {
        val productItem = productList[position]
        holder.bind(productItem)
    }

    class BestDealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private lateinit var tvHomeProductName: TextView
        private lateinit var tvRatingStar: TextView
        private lateinit var tvCountRatings: TextView
        private lateinit var tvPriceRv: TextView
        private lateinit var tvAttribute: TextView
        private lateinit var tvRvHomeOffer: TextView
        private lateinit var btnAddHomeRv: Button
        private lateinit var ivRvHomeImage: ImageView

        init {
            initViews(itemView)
        }

        private fun initViews(itemView: View) {
            tvHomeProductName = itemView.findViewById(R.id.tvHomeProductName)
            tvRatingStar = itemView.findViewById(R.id.tvRatingStar)
            tvRvHomeOffer = itemView.findViewById(R.id.tvRvHomeOffer)
            tvPriceRv = itemView.findViewById(R.id.tvPriceRv)
            tvCountRatings = itemView.findViewById(R.id.tvCountRatings)
            tvAttribute = itemView.findViewById(R.id.tvAttribute)
            ivRvHomeImage = itemView.findViewById(R.id.ivRvHomeImage)
            btnAddHomeRv = itemView.findViewById(R.id.btnAddHomeRv)

        }
        fun bind(productItem: ProductItem){
            tvHomeProductName.text = productItem.title
            val rating = 3.8
            tvRatingStar.text = rating.toString()
            tvPriceRv.text = "\u20B9" + productItem.price
            tvRvHomeOffer.text = productItem.discount.toString()
            tvCountRatings.text = "69 Ratings"
            ivRvHomeImage.setImageResource(productItem.images)
            ivRvHomeImage.setOnClickListener(View.OnClickListener { v ->
                val intent = Intent(v.context, HomeScreenActivity::class.java)
                intent.putExtra("id", productItem.id)
                v.context.startActivity(intent)
            })
            btnAddHomeRv.setOnClickListener { v ->
                if (PreferenceHelper.readBooleanFromPreference("isLogin", false)) {
                    Toast.makeText(v.context, "Added to Cart", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(v.context, LoginActivity::class.java)
                    v.context.startActivity(intent)
                }
            }
        }
    }
}