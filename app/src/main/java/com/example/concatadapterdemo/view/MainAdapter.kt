package com.example.concatadapterdemo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.concatadapterdemo.R
import com.example.concatadapterdemo.model.MainBean
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(
    private val bean: MainBean, private val displayWidth: Int
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_main, parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bean, displayWidth)
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(bean: MainBean, windowWidth: Int) {
            Glide.with(itemView.image_view.context)
                .load(bean.resourceId)
                .into(itemView.image_view)
            val linearParams = itemView.image_view.layoutParams
            linearParams.width = windowWidth
            linearParams.height = windowWidth * bean.height / bean.width
            itemView.image_view.layoutParams = linearParams
        }
    }
}