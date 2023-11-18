package com.example.store101.models

data class CartItem(
    val itemId: Int,
    val quantity: Int,
    val price: Double,
    val isAvailable: Boolean
)
