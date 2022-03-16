package com.janirefernandez.artviewapp.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.janirefernandez.artviewapp.R
import com.janirefernandez.artviewapp.data.model.Record
import com.janirefernandez.artviewapp.databinding.ActivityMainBinding
import com.janirefernandez.artviewapp.ui.adapter.RecordAdapter
import com.janirefernandez.artviewapp.ui.viewmodel.ArtViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var recordAdapter: RecordAdapter

    private val artViewModel: ArtViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        artViewModel.onCreate()
        initRecyclerView(ArrayList())

        artViewModel.artModelList.observe(this, Observer {
            updateData(it)
        })
    }

    private fun initRecyclerView(recordList: List<Record>) {
        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        recordAdapter = RecordAdapter(recordList) { onItemSelected(it) }
        binding.recyclerView.adapter = recordAdapter

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    artViewModel.onCreate()
                }
            }
        })

    }

    private fun updateData(recordList: List<Record>) {
        recordAdapter.updateData(recordList)
    }

    private fun onItemSelected(record: Record) {
        Toast.makeText(this, record.url, Toast.LENGTH_SHORT).show()
    }

}