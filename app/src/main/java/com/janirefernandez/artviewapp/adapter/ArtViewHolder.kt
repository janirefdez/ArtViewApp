package com.janirefernandez.artviewapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.janirefernandez.artviewapp.Art
import com.janirefernandez.artviewapp.databinding.ItemArtBinding

class ArtViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemArtBinding.bind(view)

    fun render(art: Art, onClickListener: (Art) -> Unit) {
        binding.tvTitle.text = art.title
        binding.tvAuthor.text = art.author
        Glide.with(binding.ivArtImage.context).load(art.image).into(binding.ivArtImage)

        itemView.setOnClickListener {
            onClickListener(art)
        }
    }
}