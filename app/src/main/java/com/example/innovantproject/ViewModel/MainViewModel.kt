package com.example.innovantproject.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.innovantproject.Response.ProductResponse
import com.example.innovantproject.Retrofit.RetroInstance
import com.example.innovantproject.Retrofit.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {

    lateinit var  productResponse: MutableLiveData<ProductResponse>

    fun getObserveProductResponse(): MutableLiveData<ProductResponse>{
         productResponse = MutableLiveData()
        return productResponse
    }


    fun makeApiCall() :  MutableLiveData<ProductResponse>
    {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val call = retroInstance.getProductData("1812","en","KW")
            call.enqueue(object : Callback<ProductResponse>{
                override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                    productResponse.postValue(response.body())
                }

                override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                    productResponse.postValue(null)
                }
            })
        return productResponse;
    }

}