package com.example.devfestspb.fakeList

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper


class DragManageAdapter(adapter: Adapter, dragDirs: Int, swipeDirs: Int) :
    ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    private var nameAdapter = adapter

    override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
        nameAdapter.removeItem(p0.adapterPosition)
    }

    override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
        nameAdapter.swapItems(p1.adapterPosition, p2.adapterPosition)
        return true
    }
}