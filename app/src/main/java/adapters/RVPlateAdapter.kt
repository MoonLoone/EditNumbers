package adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.databinding.RvItemBinding

class RVPlateAdapter(intArray: IntArray?) : RecyclerView.Adapter<RVPlateAdapter.RVViewHolder>() {

    val listOfNumbers = intArray?.toMutableList() ?: mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RVViewHolder(
        RvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        with(holder) {
            with(binding) {
                with(tvItem) {
                    if (position.mod(2) == 1) {
                        setBackgroundColor(Color.RED)
                    } else {
                        setBackgroundColor(Color.BLUE)
                    }
                    maxLines = 1
                    text = position.toString()
                }
            }
        }
    }

    override fun getItemCount() = listOfNumbers.size

    inner class RVViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun addPlate() {
        if (listOfNumbers.isEmpty()) listOfNumbers.add(1)
        else listOfNumbers.add(listOfNumbers.last() + 1)
        notifyItemInserted(listOfNumbers.size)
    }
}