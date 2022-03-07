package com.janirefernandez.artviewapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.janirefernandez.artviewapp.adapter.ArtAdapter
import com.janirefernandez.artviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ArtAdapter(ArtProvider.artList) { onItemSelected(it) }
    }

    private fun onItemSelected(art: Art) {
        Toast.makeText(this, art.title, Toast.LENGTH_SHORT).show()
    }
}