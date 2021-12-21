package com.example.innovantproject.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetroInstance {

    companion object{

        val baseurl = "http://mobicraftsv2.com/bloc49/api/v3/"

        fun getRetroInstance():Retrofit{

            var httpinte = OkHttpClient.Builder()
                    .callTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS).build()

            return Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create()).client(httpinte)
                .build()
        }

    }
}