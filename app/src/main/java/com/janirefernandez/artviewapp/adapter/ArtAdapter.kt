package com.janirefernandez.artviewapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.janirefernandez.artviewapp.Art
import com.janirefernandez.artviewapp.R

class ArtAdapter(private val artList: List<Art>, private val onClickListener: (Art) -> Unit) : RecyclerView.Adapter<ArtViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ArtViewHolder(layoutInflater.inflate(R.layout.item_art, parent, false))
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        val item = artList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = artList.size
}