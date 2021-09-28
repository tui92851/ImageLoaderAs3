package com.uni.image

import android.app.Dialog
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(var list:ArrayList<MovieModel>): RecyclerView.Adapter<ImageAdapter.Viewholder>() {
    class Viewholder(itemView: View):RecyclerView.ViewHolder(itemView){
        var textValue: TextView = itemView.findViewById(R.id.title)
        var imageView: ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.textValue.text = list[position].text
        holder.imageView.setImageResource(list[position].imageId)

        holder.itemView.setOnClickListener {
            val dialog = Dialog(holder.imageView.context)
            dialog.setContentView(R.layout.movie_detail_dialog)
            dialog.setTitle(list[position].text)
            val image = dialog.findViewById<ImageView>(R.id.imageView2)
            image.setImageResource(list[position].imageId)
            dialog.show()
        }
    }
}