package com.example.homework1.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.databinding.RvItemBinding

class RVPlateAdapter(listSize: Int) :
    ListAdapter<Int, RVPlateAdapter.RVViewHolder>(DiffCallBack()) {
    init {
        submitList(MutableList(listSize){it})
    }

    class DiffCallBack : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int) = (oldItem == newItem)
        override fun areContentsTheSame(oldItem: Int, newItem: Int) =
            areItemsTheSame(oldItem, newItem)
    }

    class RVViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun addPlate() {
        if (currentList.isEmpty()){
            submitList(MutableList(1){it})
        }
        else{
            submitList(MutableList(currentList.size+1){it})
        }
        notifyItemInserted(currentList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RVViewHolder(
        RvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        with(holder) {
            if (position.mod(2) == 1) {
                binding.tvItem.setBackgroundColor(Color.RED)
            } else {
                binding.tvItem.setBackgroundColor(Color.BLUE)
            }
            binding.tvItem.maxLines = 1
            binding.tvItem.text = position.toString()
        }
    }

}


