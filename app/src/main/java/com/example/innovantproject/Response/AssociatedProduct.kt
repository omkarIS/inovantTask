package com.example.innovantproject.Response

data class AssociatedProduct(
    val SKU: String,
    val boutique_name: String,
    val brand_name: String,
    val currency_code: String,
    val delivery_time: String,
    val delivery_time_text: String,
    val description: String,
    val final_price: String,
    val id: Int,
    val image: String,
    val is_featured: Int,
    val name: String,
    val new_from_date: String,
    val new_to_date: String,
    val regular_price: String,
    val remaining_quantity: Int,
    val short_description: String
)