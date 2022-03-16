package com.janirefernandez.artviewapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.janirefernandez.artviewapp.R
import com.janirefernandez.artviewapp.data.model.Record

class RecordAdapter(recordList: List<Record>, private val onClickListener: (Record) -> Unit) : RecyclerView.Adapter<RecordViewHolder>() {

    private val records: ArrayList<Record> = ArrayList(recordList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecordViewHolder(layoutInflater.inflate(R.layout.item_art, parent, false))
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        val item = records[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = records.size

    fun updateData(recordList: List<Record>) {
        records.addAll(recordList)
        notifyItemRangeChanged(0, records.size)
    }
}