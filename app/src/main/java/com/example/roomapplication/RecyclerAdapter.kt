package com.example.roomapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(val list:List<String>): RecyclerView.Adapter<RecyclerAdapter.Viewholder>() {
    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_text = itemView.findViewById<TextView>(R.id.textview)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerAdapter.Viewholder {
        return Viewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.text_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder:RecyclerAdapter.Viewholder, position: Int) {
        holder.item_text.text = list[position]
    }

    override fun getItemCount(): Int=list.size


}