package com.example.harshitapractice2024.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.harshitapractice2024.R
import com.example.harshitapractice2024.data.api.BaseResponse
import com.example.harshitapractice2024.databinding.ActivityUserListBinding
import com.example.harshitapractice2024.presentation.view.adapter.UserAdapter
import com.example.harshitapractice2024.presentation.viewmodel.UserListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListActivity : AppCompatActivity() {
    private val viewModel by viewModels<UserListViewModel>()
    private val adapter = UserAdapter()
    private lateinit var binding: ActivityUserListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getUserList(1)
        binding.rv.adapter = adapter
        binding.rv.layoutManager=LinearLayoutManager(this)

    }

    private fun getUserList(pageNo:Int) {
        Log.e("started","started")
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getUserList(pageNo).collect(){

                binding.pgbBar.visibility=View.GONE
                when(it){
                    is BaseResponse.Success -> {
                        it.data?.data?.let { it1 -> adapter.updateList(it1) }
                    }

                    is BaseResponse.Loading -> {
                       binding.pgbBar.visibility=View.VISIBLE
                    }
                    is BaseResponse.Error ->{
                        Toast.makeText(this@UserListActivity,"Error:${it.msg}",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}