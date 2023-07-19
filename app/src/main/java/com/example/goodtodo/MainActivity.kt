package com.example.goodtodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File


class MainActivity : AppCompatActivity() {
    val listOfTasks = mutableListOf<String>()
    lateinit var adapter: TaskItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val onLongClickListener=object : TaskItemAdapter.OnLongClickListener{
        override fun onItemLongClicked(position: Int) {
            //1-Remove the item from the list
            listOfTasks.removeAt(position)
            //2. Notify the adapter that our data st has changed
            adapter.notifyDataSetChanged()
        }

    }
        //1. detect when the user clicks on the add task
//        findViewById<Button>(R.id.button).setOnClickListener {
//            // This code is going to execute when the user clicks on a button
//            Log.i("caren","user clicks on the button")
        listOfTasks.add("Do laundry")
        listOfTasks.add("Go for a walk")
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = TaskItemAdapter(listOfTasks, onLongClickListener)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val inputTextField= findViewById<EditText>(R.id.addTaskField)

        // set up the button and input field, so that the user can enter a task in to the list
        findViewById<Button>(R.id.button).setOnClickListener {
            //1. Grab the text the user has inputted into @+id/addTaskField
            val userInputtedTask= findViewById<EditText>(R.id.addTaskField).text.toString()
            //2. Add the String to our list of tasks: listOfTasks
            listOfTasks.add(userInputtedTask)
            // notify the adapter that our data has been updated
            adapter.notifyItemInserted(listOfTasks.size- 1)
            //reset text field
           inputTextField.setText("")

        }
    }
    // save the data that the user has inputted
    //
    //
    fun getDataFile() : File{
        return File(filesDir, "data.txt")

    }
    fun loadItems(){

    }

    fun saveItems() {
    }
}


