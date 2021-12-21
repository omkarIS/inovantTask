package com.example.innovantproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.innovantproject.Adapter.RelatedPdAdapter
import com.example.innovantproject.Adapter.ViewPageAdapter
import com.example.innovantproject.Response.AssociatedProduct
import com.example.innovantproject.Response.ConfigurableOption
import com.example.innovantproject.Response.ProductResponse
import com.example.innovantproject.ViewModel.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    lateinit var productResponse: ProductResponse
    lateinit var viewModel: MainViewModel
    lateinit var imagelist: List<String>
    var sizeList: ArrayList<String> = ArrayList()
    var colorList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sizeList.add("Select Size")
        colorList.add("Select Color")

        view_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getObserveProductResponse().observe(this, Observer<ProductResponse> {
            if (it != null) {
                productResponse = it
                if (productResponse.success)
                    setToDisplay(productResponse)
                else
                    Toast.makeText(this, productResponse.message, Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "Some thing Went Wrong .. !", Toast.LENGTH_SHORT).show()

        })
        viewModel.makeApiCall()


    }


    private fun setToDisplay(productResponse: ProductResponse) {

        imagelist = productResponse.data.images
        view_pager.adapter = ViewPageAdapter(imagelist)
        TabLayoutMediator(dot_layout, view_pager) { tab, position ->
        }.attach()

        Pd_Title.text = productResponse.data.brand_name
        Pd_title_desc.text = productResponse.data.name
        val price = productResponse.data.currency_code + " " + productResponse.data.final_price
        Pd_price.text = price
        Pd_old_price.text = productResponse.data.regular_price

        Pd_desc.text = productResponse.data.description
        Pd_old_price.text = productResponse.data.regular_price

        val temp = productResponse.data.shop + " ID : " + productResponse.data.id
        txt_blockid.text = temp

        val more = "MORE FROM " + productResponse.data.brand_name
        txt_more.text = more

        val configurableOption = productResponse.data.configurable_option
        getlist(configurableOption)
        spn_size.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sizeList)
        spn_color.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, colorList)

        val relatedList = productResponse.data.associated_products

        SetMoreFromProduct(relatedList)

    }

    private fun SetMoreFromProduct(relatedList: List<AssociatedProduct>) {

        rv_related.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = RelatedPdAdapter(relatedList)
            rv_related.adapter = adapter
        }
    }

    private fun getlist(configurableOption: List<ConfigurableOption>) {
        for (item in configurableOption) {
            if (item.type.equals("Size")) {
                for (size in item.attributes) {
                    sizeList.add(size.value)
                }
            } else {
                for (size in item.attributes) {
                    colorList.add(size.value)
                }
            }
        }
    }


}