package com.janirefernandez.artviewapp.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.janirefernandez.artviewapp.data.model.Record
import com.janirefernandez.artviewapp.databinding.ItemArtBinding

class RecordViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemArtBinding.bind(view)

    fun render(recordModel: Record, onClickListener: (Record) -> Unit) {
        binding.tvTitle.text = recordModel.objectNumber
        binding.tvYear.text = recordModel.dated
        Glide.with(binding.ivArtImage.context).load(recordModel.primaryImageUrl).centerCrop().into(binding.ivArtImage)

        itemView.setOnClickListener {
            onClickListener(recordModel)
        }
    }
}