package com.example.innovantproject.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.innovantproject.R
import com.example.innovantproject.Response.BannerModel
import kotlinx.android.synthetic.main.item_banner_image.view.*
import androidx.core.content.ContextCompat.startActivity

import com.example.innovantproject.MainActivity

import androidx.core.app.ActivityOptionsCompat

import android.content.Intent
import androidx.core.app.ActivityOptionsCompat.makeSceneTransitionAnimation
import androidx.core.content.ContextCompat


class BannerAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var bannerList : ArrayList<BannerModel> = ArrayList()
    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(position: Int, bannerList: ArrayList<BannerModel>)
        {
            val image = bannerList[position].drawable
            itemView.item_banner_img.setImageDrawable(image)

            itemView.item_banner_img.setOnClickListener {
                val intent = Intent(itemView.context, MainActivity::class.java)
                val options = makeSceneTransitionAnimation(
                    itemView.context as Activity,
                    (itemView.item_banner_img as View?)!!, "banner"
                )
                itemView.context.startActivity(intent, options.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner_image, parent , false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      if (holder is ItemViewHolder){
          holder.bind(position , bannerList )
      }
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }
}