package com.example.devfestspb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_activity)

        val recyclerview: RecyclerView = findViewById(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerview.adapter = Adapter(generateFakeValues())
    }

    private fun generateFakeValues(): List<String> {
        val values = mutableListOf<String>()
        for (i in 0..100) {
            values.add("$i element")
        }
        return values
    }
}

class Adapter(private val values: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.list_item_view, p0, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView?.text = values[p1]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null

        init {
            textView = itemView.findViewById(R.id.text_list_item)
        }
    }
}