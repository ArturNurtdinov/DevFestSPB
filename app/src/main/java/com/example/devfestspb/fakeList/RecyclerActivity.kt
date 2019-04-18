package com.example.devfestspb.fakeList

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.devfestspb.R

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        val adapter = Adapter(generateFakeValues(), genereateFakeTime())
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(DividerItemDecoration(this, manager.orientation))

        val callback = DragManageAdapter(
            adapter,
            ItemTouchHelper.UP.or(ItemTouchHelper.DOWN), ItemTouchHelper.LEFT
        )
        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(recyclerView)
    }

    private val sizeOfRecyclerView = 20

    private fun generateFakeValues(): MutableList<String> {
        val values = mutableListOf<String>()
        for (i in 0..sizeOfRecyclerView) {
            values.add("$i element")
        }
        return values
    }

    private fun genereateFakeTime(): MutableList<String> {
        val time = mutableListOf<String>()
        var hours: Int
        var minutes: Int
        for (i in 0..sizeOfRecyclerView) {
            hours = (0..23).random()
            minutes = (0..59).random()
            if ((hours < 10) && (minutes < 10)) {
                time.add("0$hours:0$minutes")
            } else if (hours < 10) {
                time.add("0$hours:$minutes")
            } else if (minutes < 10) {
                time.add("$hours:0$minutes")
            } else {
                time.add("$hours:$minutes")
            }
        }
        return time
    }
}
