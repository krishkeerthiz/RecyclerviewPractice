package com.example.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val items = listOf("text -1","text 0","text 1","text 2","text 3","text 4","text 5","text 6","text 7","text 8","text 9","text 10")
        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        val rvAdapter = RvAdapter(items)

        rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = rvAdapter
            setItemViewCacheSize(1)

        }

    }
}