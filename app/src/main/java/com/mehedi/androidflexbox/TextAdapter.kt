package com.mehedi.androidflexbox

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class TextAdapter(private val items: List<TextItem>) :
    RecyclerView.Adapter<TextAdapter.TextViewHolder>() {
    
    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_name)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_text, parent, false)
        return TextViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.text
        holder.textView.setTextColor(item.color)
        
        // Set a random background color and apply the rounded shape
        /*      val backgroundDrawable = holder.textView.background as GradientDrawable
              backgroundDrawable.setColor(getRandomColor())  // Set the random background color*/
        //holder.textView.background = backgroundDrawable
    }
    
    override fun getItemCount(): Int = items.size
    
    // Function to generate random colors
    private fun getRandomColor(): Int {
        return Color.argb(
            255,
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }
}
