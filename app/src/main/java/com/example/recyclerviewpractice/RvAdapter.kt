package com.example.recyclerviewpractice

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.databinding.RvViewBinding

class RvAdapter(private val data: List<String>) : RecyclerView.Adapter<RvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        Log.d(TAG, "onCreateViewHolder: Recyclerview")
        val view = LayoutInflater.from(parent.context)
        val binding = RvViewBinding.inflate(view, parent, false)
        return RvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: Recyclerview ${data[position]}")
        holder.bind(data[position])
    }

    override fun getItemCount():Int {
        Log.d(TAG, "getItemCount: Recyclerview ${data.size}")
        return data.size
    }
}

class RvViewHolder(private val binding: RvViewBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String){
        binding.textView.text = data
    }
}