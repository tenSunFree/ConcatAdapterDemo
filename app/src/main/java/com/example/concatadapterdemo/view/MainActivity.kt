package com.example.concatadapterdemo.view

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import com.example.concatadapterdemo.R
import com.example.concatadapterdemo.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val presenter = MainPresenter()
        val metrics = DisplayMetrics()
        display?.getRealMetrics(metrics)
        val displayWidth = metrics.widthPixels
        val singMainAdapter = MainAdapter(presenter.getSing(), displayWidth)
        val partyMainAdapter = MainAdapter(presenter.getParty(), displayWidth)
        val listOfAdapter = listOf(singMainAdapter, partyMainAdapter)
        val concatAdapter = ConcatAdapter(listOfAdapter)
        recycler_view.adapter = concatAdapter
    }
}