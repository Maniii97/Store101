package com.example.store101.models

data class ProductItem(
    val id: Int,
    val images: Int,
    val title: String,
    val category: String,
    val price: Double,
    val discount: Int,
    val isVeg: Boolean,
    val aboutProduct: String,
    val isAvailable: Boolean
)
