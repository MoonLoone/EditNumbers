package com.example.homework1.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.databinding.RvItemBinding

class RVPlateAdapter(listSize: Int) : RecyclerView.Adapter<RVPlateAdapter.RVViewHolder>() {

    private val listOfNumbers = MutableList(listSize){it}

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

    override fun getItemCount() = listOfNumbers.size

    class RVViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun addPlate() {
        if (listOfNumbers.isEmpty()) listOfNumbers.add(1)
        else listOfNumbers.add(listOfNumbers.last() + 1)
        notifyItemInserted(listOfNumbers.size)
    }
}