package com.kanyideveloper.jsonplaceholderapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kanyideveloper.jsonplaceholderapi.databinding.RecyclerRowBinding

class PhotosAdapter : ListAdapter<JsonPlaceholder.JsonPlaceholderItem, PhotosAdapter.MyViewHolder>(MyDiffUtil) {
    object MyDiffUtil : DiffUtil.ItemCallback<JsonPlaceholder.JsonPlaceholderItem>(){
        override fun areItemsTheSame(
            oldItem: JsonPlaceholder.JsonPlaceholderItem,
            newItem: JsonPlaceholder.JsonPlaceholderItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: JsonPlaceholder.JsonPlaceholderItem,
            newItem: JsonPlaceholder.JsonPlaceholderItem
        ): Boolean {
           return oldItem.id == newItem.id
        }

    }
    inner class MyViewHolder(private val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: JsonPlaceholder.JsonPlaceholderItem?) {
            binding.textView.text = item?.title
            Glide.with(binding.image)
                .load(item?.url)
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val item = getItem(position)
        holder.bind(item)
    }
}