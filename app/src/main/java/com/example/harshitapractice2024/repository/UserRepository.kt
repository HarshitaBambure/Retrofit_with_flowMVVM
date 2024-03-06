package com.example.harshitapractice2024.repository

import com.example.harshitapractice2024.data.api.UserApi
import com.example.harshitapractice2024.data.model.response.ListUsersResponse

class UserRepository constructor(val userApi: UserApi) {

    suspend fun getUserList(pageNo : Int) : ListUsersResponse{
        return userApi.getUserList(pageNo)
    }
}