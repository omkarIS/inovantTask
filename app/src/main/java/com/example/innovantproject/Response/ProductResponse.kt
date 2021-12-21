package com.example.innovantproject.Response

data class ProductResponse(
    val `data`: Data,
    val message: String,
    val status: Int,
    val success: Boolean
)