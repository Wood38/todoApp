package com.example.goodtodo

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskItemAdapter(val listOfItems: List<String>, val longClickListener:OnLongClickListener)
    : RecyclerView.Adapter<TaskItemAdapter.ViewHolder>() {
    interface OnLongClickListener{
        fun onItemLongClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item= listOfItems.get(position)
        holder.textView.text=item
    }

    // Provide a direct reference to each of the views within a data item
// Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView

        init {
            textView= itemView.findViewById(android.R.id.text1)
            itemView.setOnLongClickListener {
              longClickListener.onItemLongClicked(adapterPosition)
                true
            }
        }
    }
}

