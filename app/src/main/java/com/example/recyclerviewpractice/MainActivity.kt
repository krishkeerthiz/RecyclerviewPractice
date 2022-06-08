package com.example.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
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


        val items = getSampleArrayList()
        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        val rvAdapter = RvAdapter(items)

        rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = rvAdapter
            setItemViewCacheSize(1)
            //rvAdapter.submitList(items) need to submit list while using list adapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL)) // adds line between views
        }

//        val items = mutableListOf("text -1","text 0","text 1","text 2","text 3","text 4","text 5","text 6","text 7","text 8","text 9","text 10")
//        rv.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = rvAdapter
//            setItemViewCacheSize(1)
//            //rvAdapter.submitList(items) need to submit list while using list adapter
//            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL)) // adds line between views
//        }

//        binding.button.setOnClickListener {
//            items.add("Text 11")
//            rvAdapter.notifyDataSetChanged()
//        }

//        binding.button.setOnClickListener {
//            items.add("Text 11")
//            rvAdapter.notifyItemInserted(items.size - 1)
//            rv.scrollToPosition(items.size - 1)  // auto scrolls to the inserted item position
//            //scrolling is smooth
//        }

//        binding.button.setOnClickListener {
//            items.add(0, "Text -2")   // insertion starts from 0
//            rvAdapter.notifyItemInserted(0)
//            rv.smoothScrollToPosition(0)  // auto scrolls to the inserted item position
//            //scrolling is smooth now
//        }

//        binding.button.setOnClickListener {
//            val position = items.size - 1
//            items.removeAt(position)
//            rvAdapter.notifyItemRemoved(position) // position from which item is removed
//            rv.smoothScrollToPosition(16)  // giving scroll position beyond size does not cause any issue
//            //scrolling is smooth now
//        }

//        binding.button.setOnClickListener {
//            val position = items.size - 1
//            items[position] = "Text 999"
//            rvAdapter.notifyItemChanged(position) // position from which item is removed
//            rv.smoothScrollToPosition(position)  // from start of the items, scrolling to the end updates ui without
//            // notify item changed being called, note: this wont work when the item to changed is visible
//        }

//        binding.button.setOnClickListener {
//            val position = items.size
//            items.addAll(listOf("Text 11", "Text 12", "Text 13"))
//            rvAdapter.notifyItemRangeInserted(position, 3)
//            rv.scrollToPosition(position)  // shows first added item at the end of the screen we need to scroll to see more added items
//        }


        // List adapter
//        binding.button.setOnClickListener {
//            val position = items.size
//            items.addAll(listOf("Text 11", "Text 12", "Text 13"))
//            rvAdapter.submitList(items) // DiffUtil takes care of the check
//            rv.scrollToPosition(position)  // shows first added item at the end of the screen we need to scroll to see more added items
//        }

//        binding.button.setOnClickListener {
//            val position = items.size
//            items.addAll(listOf("Text 11", "Text 12", "Text 13"))
//            rvAdapter.updateItems(items)
//            rv.scrollToPosition(position)  // shows first added item at the end of the screen we need to scroll to see more added items
//            // Smoothscrolltopoisition is not working in diffutils
//        }

       // LinearSnapHelper().attachToRecyclerView(rv) // works for horizontal
    }


    private fun getSampleArrayList(): MutableList<Any> {
        val items: MutableList<Any> = mutableListOf()
        items.add(User("Dany Targaryen", "Valyria"))
        items.add(User("Rob Stark", "Winterfell"))
        items.add("Walter White")
        items.add(User("Jon Snow", "Castle Black"))
        items.add("Michael scofield")
        items.add(User("Tyrion Lanister", "King's Landing"))
        return items
    }
}

data class User(val firstName: String, val lastName: String)
