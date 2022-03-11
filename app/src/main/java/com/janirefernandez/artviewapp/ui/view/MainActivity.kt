package com.janirefernandez.artviewapp.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.janirefernandez.artviewapp.data.model.Record
import com.janirefernandez.artviewapp.databinding.ActivityMainBinding
import com.janirefernandez.artviewapp.ui.adapter.RecordAdapter
import com.janirefernandez.artviewapp.ui.viewmodel.ArtViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val artViewModel: ArtViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        artViewModel.onCreate()

        artViewModel.artModelList.observe(this, Observer {
            initRecyclerView(it)
        })
    }

    private fun initRecyclerView(recordList: List<Record>) {
        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = RecordAdapter(recordList) { onItemSelected(it) }
    }

    private fun onItemSelected(record: Record) {
        Toast.makeText(this, record.dated, Toast.LENGTH_SHORT).show()
    }
}