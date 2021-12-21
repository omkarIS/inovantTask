package com.example.innovantproject.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.innovantproject.R
import kotlinx.android.synthetic.main.item_image.view.*

class ViewPageAdapter(private var img_url: List<String>) : RecyclerView.Adapter<ViewPageAdapter.PagerHolder>() {


    inner class PagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img : ImageView = itemView.findViewById(R.id.item_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerHolder {
        return PagerHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent , false))
    }

    override fun onBindViewHolder(holder: PagerHolder, position: Int) {

        var currentImage = img_url.get(position)

        Glide.with(holder.img)
            .load(currentImage)
            .placeholder(R.drawable.ic_thumnail)
            .error(R.drawable.ic_thumnail)
            .fallback(R.drawable.ic_thumnail)
            .into(holder.img)
    }

    override fun getItemCount(): Int {
        return img_url.size
    }
}