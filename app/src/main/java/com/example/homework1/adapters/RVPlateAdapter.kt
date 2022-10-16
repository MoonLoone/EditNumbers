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

    class RVViewHolder(val binding: RecycleViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.tvItem.setBackgroundColor(
                if (position.mod(2) == 1) Color.RED else Color.BLUE
            )
            binding.tvItem.text = position.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RVViewHolder(
        RecycleViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.bind(position)
    }

}


