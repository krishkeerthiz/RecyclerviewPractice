package com.example.recyclerviewpractice

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.databinding.RvView2Binding
import com.example.recyclerviewpractice.databinding.RvViewBinding

class RvAdapter(private var data: MutableList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW1 = 1
    private val VIEW2 = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d(TAG, "onCreateViewHolder: Recyclerview")
        val viewHolder: RecyclerView.ViewHolder
        val view = LayoutInflater.from(parent.context)

        viewHolder = when (viewType) {
            VIEW1 -> {
                val binding = RvViewBinding.inflate(view, parent, false)
                RvViewHolder(binding)
            }
            VIEW2 -> {
                val binding = RvView2Binding.inflate(view, parent, false)
                RvViewHolder2(binding)
            }
            else -> {
                val binding = RvViewBinding.inflate(view, parent, false)
                RvViewHolder(binding)
            }
        }

        return viewHolder
//        val binding = RvViewBinding.inflate(view, parent, false)
//        return RvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: Recyclerview ${data[position]}")
        when (holder.itemViewType) {
            VIEW1 -> {
                val vh1 = holder as RvViewHolder
                vh1.bind(data[position] as String)
            }
            VIEW2 -> {
                val vh2 = holder as RvViewHolder2
                vh2.bind(data[position] as User)
            }
            else -> {
                val vh1 = holder as RvViewHolder
                vh1.bind(data[position] as String)
            }
        }
    }

    override fun getItemCount():Int {
        Log.d(TAG, "getItemCount: Recyclervie ${data.size}")
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(data[position]){
            is String -> 1
            is User -> 2
            else -> -1
        }
    }

}

//class RvAdapter(private var data: List<String>) : RecyclerView.Adapter<RvViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
//        Log.d(TAG, "onCreateViewHolder: Recyclerview")
//        val view = LayoutInflater.from(parent.context)
//        val binding = RvViewBinding.inflate(view, parent, false)
//        return RvViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
//        Log.d(TAG, "onBindViewHolder: Recyclerview ${data[position]}")
//        holder.bind(data[position])
//    }
//
//    override fun getItemCount():Int {
//        Log.d(TAG, "getItemCount: Recyclervie ${data.size}")
//        return data.size
//    }
//
//    fun updateItems(newData: List<String>){
//        val diffCallback = DiffCallback(data, newData)
//        val diffResult = DiffUtil.calculateDiff(diffCallback)
//
//        data = newData
//
//        diffResult.dispatchUpdatesTo(this) // calls adapter's notify methods after diff is computed
//    }
//}

//class DiffCallback(private val oldItems: List<String>, private val newItems: List<String>)
//    : DiffUtil.Callback(){
//    override fun getOldListSize() = oldItems.size
//
//    override fun getNewListSize() = newItems.size
//
//    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//        return oldItems[oldItemPosition] == newItems[newItemPosition]
//    }
//
//    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//        return oldItems[oldItemPosition] == newItems[newItemPosition]
//    }
//
//}

//class RvAdapter(private val data: List<String>) : ListAdapter<String, RvViewHolder>(DIFF_CALLBACK) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
//        Log.d(TAG, "onCreateViewHolder: Recyclerview")
//        val view = LayoutInflater.from(parent.context)
//        val binding = RvViewBinding.inflate(view, parent, false)
//        return RvViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
//        Log.d(TAG, "onBindViewHolder: Recyclerview ${data[position]}")
//        holder.bind(getItem(position))
//    }
//
////    override fun getItemCount():Int {
////        Log.d(TAG, "getItemCount: Recyclerview ${data.size}")
////        return data.size
////    }
//
//    companion object{
//        val DIFF_CALLBACK =  object: DiffUtil.ItemCallback<String>(){
//            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//                return oldItem == newItem
//            }
//
//            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//                return oldItem == newItem
//            }
//
//        }
//    }
//}


class RvViewHolder(private val binding: RvViewBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String){
        binding.textView.text = data
    }
}

class RvViewHolder2(private val binding: RvView2Binding): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: User){
        binding.textView.text = data.firstName
        binding.textView2.text = data.lastName
    }
}

//Note:
//fun updateItems(newData: List<String>){
//
//    val diffCallback = DiffCallback(listOf("198"), listOf("Text 17"))
//    Log.d(TAG, "updateItems: ${data.size}  ${newData.size}")
//    Log.d(TAG, "updateItems: ${data.hashCode()}  ${newData.hashCode()}")  // both hashcodes are same, but data varies
//    val diffResult = DiffUtil.calculateDiff(diffCallback)
//
//    //data = newData
//
//    diffResult.dispatchUpdatesTo(this) // calls adapter's notify methods after diff is computed
//}