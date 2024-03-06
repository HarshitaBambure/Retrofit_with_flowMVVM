package com.example.harshitapractice2024.presentation.view.adapter

import android.app.LauncherActivity.ListItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.harshitapractice2024.data.model.response.Data
import com.example.harshitapractice2024.databinding.ItemListBinding

class UserAdapter: Adapter<UserAdapter.UserViewHolder>() {

    val listData = mutableListOf<Data>()

    class UserViewHolder(val binding: ItemListBinding): ViewHolder(binding.root) {
        fun bindData(data: Data) {
            binding.txtEmail.setText(data.email)
            binding.txtName.setText(data.firstName + data.lastName)
            Glide
                .with(binding.ivBack.context)
                .load(data.avatar)
                .centerCrop()
                .into(binding.ivBack);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
    val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(listData[position])
    }

    fun updateList(data:List<Data>){
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }
}