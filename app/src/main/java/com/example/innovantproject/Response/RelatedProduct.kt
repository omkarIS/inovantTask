package com.example.innovantproject.Response

data class RelatedProduct(
    val SKU: String,
    val brand_name: String,
    val currency_code: String,
    val delivery_time: String,
    val delivery_time_text: String,
    val description: String,
    val final_price: String,
    val id: Int,
    val image: String,
    val is_featured: Int,
    val is_saleable: Int,
    val name: String,
    val new_from_date: String,
    val new_to_date: String,
    val regular_price: String,
    val remaining_quantity: Int,
    val shipping_free_returns: Any,
    val shop_id: Int,
    val short_description: Any,
    val specification: Any
)