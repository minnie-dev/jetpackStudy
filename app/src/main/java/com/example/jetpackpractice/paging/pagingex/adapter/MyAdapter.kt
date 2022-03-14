package com.example.jetpackpractice.paging.pagingex.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackpractice.databinding.ItemLayoutBinding
import com.example.jetpackpractice.paging.pagingex.adapter.MyAdapter.MyViewHolder
import com.example.jetpackpractice.paging.pagingex.model.Post2

class MyAdapter
    : PagingDataAdapter<Post2, MyViewHolder>(IMAGE_COMPARATOR) {


    class MyViewHolder(private val binding:ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post:Post2){
            Log.d("Adapter","bind 됨 ${post.id}")
            binding.userIdText.text = post.myUserId.toString()
            binding.idText.text = post.id.toString()
            binding.titleText.text = post.title
            binding.bodyText.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        if(currentItem!=null){
            holder.bind(currentItem)
        }
    }

    companion object {
        private val IMAGE_COMPARATOR = object : DiffUtil.ItemCallback<Post2>() {
            override fun areItemsTheSame(oldItem: Post2, newItem: Post2) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Post2, newItem: Post2) =
                oldItem == newItem
        }

    }
}

