package com.example.devfestspb.fakeList

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.devfestspb.R

class Adapter(private val elements: ElementR) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    companion object{
        const val ADAPTER_LOG = "ADAPTER"
        const val MOVING_LOG = "MOVING_LOG"
        const val DELETING_LOG = "DELETING_LOG"
    }


    override fun getItemCount(): Int = elements.values.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        Log.d(ADAPTER_LOG, "onCreateViewHolder")
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.list_item_view, p0, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        Log.d(ADAPTER_LOG, "onBindViewHolder for position $p1")
        p0.textView?.text = elements.values[p1]
        p0.timeView?.text = elements.time[p1]
    }

    fun swapItems(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition..toPosition) {
                elements.values[i] = elements.values.set(i + 1, elements.values[i])
            }
        } else {
            for (i in fromPosition..toPosition + 1) {
                elements.values[i] = elements.values.set(i - 1, elements.values[i])
            }
        }
        Log.d(MOVING_LOG, "moving item from $fromPosition to $toPosition")
        notifyItemMoved(fromPosition, toPosition)
    }

    private var size = 0
    fun removeItem(position: Int) {
        Log.d(DELETING_LOG, "removed item on position $position")
        elements.values.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, elements.values.size)
        size = elements.values.size
        Log.d(DELETING_LOG, "after removing values size = $size")
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        var timeView: TextView? = null
        init {
            textView = itemView.findViewById(R.id.text_list_item)
            timeView = itemView.findViewById(R.id.time_view)
        }
    }
}
