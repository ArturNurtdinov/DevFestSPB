package com.example.devfestspb.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.example.devfestspb.R
import com.example.devfestspb.data.Speaker
import kotlinx.android.synthetic.main.list_item_view.view.*
import kotlin.collections.ArrayList

class Adapter(private val elements: ArrayList<Speaker>, private val clickListener: (Speaker) -> Unit) :
    RecyclerView.Adapter<Adapter.ViewHolder>(){

    companion object{
        const val ADAPTER_LOG = "ADAPTER"
    }


    override fun getItemCount(): Int = elements.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        Log.d(ADAPTER_LOG, "onCreateViewHolder")
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.list_item_view, p0, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        Log.d(ADAPTER_LOG, "onBindViewHolder for position $p1")
        /*p0.nameView?.text = elements[p1].firstName + " " + elements[p1].lastName
        //p0.moreButton?.text = elements[p1].id
        p0.jobView?.text = elements[p1].jobTitle*/
        p0.bind(elements[p1], clickListener)
    }

/*    fun swapItems(fromPosition: Int, toPosition: Int) {
        var listOfName = mutableListOf<String>()
        var listOfId = mutableListOf<String>()
        for (i in 0 until elements.size){
            listOfName.add(elements[i].firstName)
            listOfId.add(elements[i].id)
        }
        if (fromPosition < toPosition) {
            for (i in fromPosition..toPosition) {
               //elements[i].name = elements[i + 1].name//elements[i].set(i + 1, elements[i].name)
                elements[i].firstName = listOfName.set(i + 1, elements[i].firstName)
            }
        } else {
            for (i in fromPosition..toPosition + 1) {
                //elements[i].name = elements[i + 1].name//elements.values.set(i - 1, elements.values[i])
                elements[i].firstName = listOfName.set(i - 1, elements[i].firstName)
            }
        }
        Log.d(MOVING_LOG, "moving item from $fromPosition to $toPosition")
        notifyItemMoved(fromPosition, toPosition)
    }*/

   /* private var size = 0
    fun removeItem(position: Int) {
        Log.d(DELETING_LOG, "removed item on position $position")
        elements.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, elements.size)
        size = elements.size
        Log.d(DELETING_LOG, "after removing values size = $size")
    }*/

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameView: TextView? = null
        var moreButton: ImageButton? = null
        var jobView: TextView? = null
        init {
            nameView = itemView.findViewById(R.id.name)
            moreButton = itemView.findViewById(R.id.more)
            jobView = itemView.findViewById(R.id.job_title)
        }

        @SuppressLint("SetTextI18n")
        fun bind(speaker: Speaker, clickListener: (Speaker) -> Unit){
            itemView.more.setOnClickListener { clickListener(speaker) }
            itemView.name.text = speaker.firstName + " " + speaker.lastName
            itemView.job_title.text = speaker.jobTitle
        }
    }
}
