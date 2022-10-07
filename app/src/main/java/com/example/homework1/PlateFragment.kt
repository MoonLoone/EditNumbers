package com.example.homework1

import adapters.RVPlateAdapter
import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.databinding.FragmentPlateBinding

class PlateFragment : Fragment() {

    private lateinit var binding: FragmentPlateBinding
    private lateinit var adapter: RVPlateAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val spanCount:Int = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 3;
            else 4;
        binding = FragmentPlateBinding.inflate(inflater, container, false)
        adapter = RVPlateAdapter(ResourcesCompat.getDrawable(resources, R.drawable.plate, null)?.toBitmap()?: Bitmap.createBitmap(50,50,Bitmap.Config.RGB_565))
        binding.rvPlates.setHasFixedSize(false)
        binding.rvPlates.layoutManager = GridLayoutManager(context,spanCount)
        binding.rvPlates.adapter = adapter

        return binding.root
    }

    fun addElement(){
        val number = adapter.addPlate()
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }


    }

}