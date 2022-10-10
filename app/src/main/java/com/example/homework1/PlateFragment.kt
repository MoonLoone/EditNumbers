package com.example.homework1

import com.example.homework1.adapters.RVPlateAdapter
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework1.databinding.FragmentPlateBinding
import com.example.homework1.utils.Constants

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
        val binding = FragmentPlateBinding.inflate(inflater, container, false)
        savedInstanceState?.let { listSize = it.getInt(Constants.GET_INFO_FROM_INSTANCE) }
        val adapter = RVPlateAdapter(listSize)
        binding.rvPlates.adapter = adapter
        binding.rvPlates.layoutManager = GridLayoutManager(context, spanCount)
        binding.button.setOnClickListener {
            adapter.addPlate()
            listSize = adapter.itemCount
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Constants.GET_INFO_FROM_INSTANCE, listSize)
    }
}