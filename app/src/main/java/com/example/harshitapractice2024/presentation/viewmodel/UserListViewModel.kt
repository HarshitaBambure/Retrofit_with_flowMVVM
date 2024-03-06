package com.example.harshitapractice2024.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.harshitapractice2024.data.api.BaseResponse
import com.example.harshitapractice2024.data.api.UserApi
import com.example.harshitapractice2024.data.model.response.ListUsersResponse
import com.example.harshitapractice2024.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserListViewModel : ViewModel() {
    val userRepository = UserRepository(userApi = UserApi.invoke()!!)

    fun getUserList(pageNo : Int): Flow<BaseResponse<ListUsersResponse>>{
        return flow {
            emit(BaseResponse.Loading())
            try {
                val response = userRepository.getUserList(pageNo)
                emit(BaseResponse.Success((response)))

            } catch (ex : Exception){
                BaseResponse.Error(ex.message)
            }
        }
    }
}