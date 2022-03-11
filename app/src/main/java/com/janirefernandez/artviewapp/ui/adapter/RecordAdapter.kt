package com.janirefernandez.artviewapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.janirefernandez.artviewapp.R
import com.janirefernandez.artviewapp.data.model.Record

class RecordAdapter(private val recordList: List<Record>, private val onClickListener: (Record) -> Unit) : RecyclerView.Adapter<RecordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecordViewHolder(layoutInflater.inflate(R.layout.item_art, parent, false))
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        val item = recordList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = recordList.size
}