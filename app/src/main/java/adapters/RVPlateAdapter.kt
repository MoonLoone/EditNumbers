package adapters

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.databinding.RvItemBinding

class RVPlateAdapter(val plateImage: Bitmap) : RecyclerView.Adapter<RVPlateAdapter.RVViewHolder>() {

    private val listOfNumbers = mutableListOf<Int>()

    inner class RVViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return RVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        with(holder){
            val tempBitmap = Bitmap.createBitmap(plateImage.width, plateImage.height, Bitmap.Config.RGB_565)
            val canvas = Canvas(tempBitmap)
            val myPaint = Paint()
            myPaint.textSize = 75f
            canvas.drawBitmap(plateImage, Rect(0,0,plateImage.width, plateImage.height),
                Rect(0,0,plateImage.width, plateImage.height), null)
            canvas.drawText(position.toString(), (plateImage.width / 1.5).toFloat(), (plateImage.height / 1.5).toFloat(), myPaint)
            binding.imageView.setImageBitmap(tempBitmap)
        }
    }

    override fun getItemCount() = listOfNumbers.size

    fun addPlate(): Int{
        if(listOfNumbers.isEmpty()) listOfNumbers.add(1)
        else listOfNumbers.add(listOfNumbers.last()+1)
        notifyItemInserted(listOfNumbers.size)
        Log.d("Ket", listOfNumbers.size.toString())
        return listOfNumbers.size+1
    }

}