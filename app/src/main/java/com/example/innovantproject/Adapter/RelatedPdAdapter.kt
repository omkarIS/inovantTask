package com.example.innovantproject.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.innovantproject.R
import com.example.innovantproject.Response.AssociatedProduct

class RelatedPdAdapter(var relatedList :List<AssociatedProduct> ) :RecyclerView.Adapter<RelatedPdAdapter.RelatedViewHolder>()  {
    inner class RelatedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img = itemView.findViewById<ImageView>(R.id.img_related)
        var brandname = itemView.findViewById<TextView>(R.id.item_Pd_Title)
        var name = itemView.findViewById<TextView>(R.id.item_Pd_title_desc)
        var price = itemView.findViewById<TextView>(R.id.item_Pd_price)
        var oldprice = itemView.findViewById<TextView>(R.id.item_Pd_old_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedViewHolder {
        return RelatedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_related, parent , false))
    }

    override fun onBindViewHolder(holder: RelatedViewHolder, position: Int) {

        var currentObj = relatedList.get(position)
        var url = currentObj.image

        holder.brandname.text = currentObj.brand_name
        holder.name.text = currentObj.name
        var temp = currentObj.currency_code +" "+currentObj.final_price
        holder.price.text = temp
        holder.oldprice.text = currentObj.regular_price

        Glide.with(holder.img)
            .load(url)
            .placeholder(R.drawable.ic_thumnail)
            .error(R.drawable.ic_thumnail)
            .fallback(R.drawable.ic_thumnail)
            .into(holder.img)

    }

    override fun getItemCount(): Int {
        return relatedList.size
    }
}