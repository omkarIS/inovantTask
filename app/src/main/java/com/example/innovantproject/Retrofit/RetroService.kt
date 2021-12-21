package com.example.innovantproject.Retrofit


import com.example.innovantproject.Response.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {


    @GET("product-details?")
    fun getProductData(@Query("product_id") product_id: String , @Query("lang") lang: String , @Query("store") store: String ) : Call<ProductResponse>


}