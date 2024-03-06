package com.example.harshitapractice2024.data.api

import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


object RetrofitClient {

    var mRetrofit: Retrofit? = null

       fun getClient():Retrofit? {
            if(mRetrofit == null){
                mRetrofit = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return mRetrofit
        }
}