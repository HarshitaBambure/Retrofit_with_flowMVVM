package com.example.harshitapractice2024.data.api

import com.example.harshitapractice2024.data.model.response.ListUsersResponse
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("/api/users")
    suspend fun getUserList(@Query("page")page: Int):ListUsersResponse

    companion object{
        fun invoke():UserApi?{
            return RetrofitClient.getClient()?.create(UserApi::class.java)
        }

    }
}