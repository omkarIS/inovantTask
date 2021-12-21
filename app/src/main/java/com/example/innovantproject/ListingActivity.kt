package com.example.innovantproject

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.innovantproject.Adapter.BannerAdapter
import com.example.innovantproject.Response.BannerModel
import kotlinx.android.synthetic.main.activity_listing.*

class ListingActivity : AppCompatActivity() {
    @SuppressLint("NewApi", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing)

        val drawable = ContextCompat.getDrawable(this, R.drawable.model)
        val model = BannerModel(drawable!!)
        val bannerList : ArrayList<BannerModel> = ArrayList()
        bannerList.add(model)
        bannerList.add(model)
        bannerList.add(model)
        bannerList.add(model)
        bannerList.add(model)
        setListingData(bannerList)
    }

    private fun setListingData(list: ArrayList<BannerModel>) {
        val adapter  = BannerAdapter()
        adapter.bannerList = list
        rv_Banner.adapter = adapter
        rv_Banner.adapter?.notifyDataSetChanged()
    }
}