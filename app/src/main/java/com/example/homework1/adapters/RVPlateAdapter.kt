package com.example.homework1.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.databinding.RecycleViewItemBinding

class RVPlateAdapter :
    ListAdapter<Int, RVPlateAdapter.RVViewHolder>(DiffCallBack()) {

    class DiffCallBack : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int) = (oldItem == newItem)
        override fun areContentsTheSame(oldItem: Int, newItem: Int) =
            areItemsTheSame(oldItem, newItem)
    }

    class RVViewHolder(val binding: RecycleViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        val color = listOf<Int>(Color.RED, Color.BLUE)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RVViewHolder(
        RecycleViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        with(holder) {
            binding.tvItem.setBackgroundColor(color[position.mod(2)])
            binding.tvItem.text = position.toString()
        }
    }

}


