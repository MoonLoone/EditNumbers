package com.example.homework1

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework1.adapters.RVPlateAdapter
import com.example.homework1.databinding.FragmentPlateBinding

class PlateFragment : Fragment() {

    private var listSize = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val spanCount: Int =
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 3
            else 4
        listSize = savedInstanceState?.getInt(GET_INFO_FROM_INSTANCE)?:0
        val binding = FragmentPlateBinding.inflate(inflater, container, false)
        val adapter = RVPlateAdapter()
        adapter.submitList(MutableList(listSize){it})
        binding.rvPlates.adapter = adapter
        binding.rvPlates.layoutManager = GridLayoutManager(context, spanCount)
        binding.button.setOnClickListener {
            if (adapter.currentList.isEmpty()){
                adapter.submitList(listOf(1))
            }
            else{
                adapter.submitList(List(listSize){it})
            }
            listSize++
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(GET_INFO_FROM_INSTANCE, listSize)
    }

    companion object{
        const val GET_INFO_FROM_INSTANCE = "get data from instance"
    }
}