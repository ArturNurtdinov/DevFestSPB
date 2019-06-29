package com.example.devfestspb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import android.net.ConnectivityManager
import android.content.Context
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.devfestspb.adapters.Adapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private var presenter: MainPresenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) = runBlocking {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_activity)
        if (isOnline()) {
            delay(1000)
            recyclerView = findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(this@MainActivity)
            recyclerView.layoutManager = manager

            val adapter = Adapter(presenter.speakerList, presenter.clickListener)
            recyclerView.adapter = adapter

            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, manager.orientation))
        } else {
            Toast.makeText(this@MainActivity, "No internet", Toast.LENGTH_LONG).show()
        }
    }

    @Suppress("DEPRECATION")
    private fun isOnline(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}
