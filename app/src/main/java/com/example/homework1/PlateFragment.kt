package com.example.homework1

import adapters.RVPlateAdapter
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework1.databinding.FragmentPlateBinding

class PlateFragment : Fragment() {
    private lateinit var adapter: RVPlateAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val spanCount: Int =
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 3
            else 4

        val binding = FragmentPlateBinding.inflate(inflater, container, false)
        adapter = RVPlateAdapter(savedInstanceState?.getIntArray("Saved array"))
        binding.rvPlates.adapter = adapter
        binding.rvPlates.layoutManager = GridLayoutManager(context, spanCount)
        binding.button.setOnClickListener {
            adapter.addPlate()
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("Saved array", adapter.listOfNumbers.toIntArray())
    }

}