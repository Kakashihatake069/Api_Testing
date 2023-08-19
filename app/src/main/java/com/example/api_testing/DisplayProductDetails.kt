package com.example.api_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api_testing.databinding.ActivityDisplayProductDetailsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayProductDetails : AppCompatActivity() {
    var apiInterface : ApiInterface? = null
    private val binding: ActivityDisplayProductDetailsBinding by lazy {
        ActivityDisplayProductDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {
        var id = intent.getIntExtra("id",0)
        apiInterface = ApiClient.getClient()?.create(ApiInterface::class.java)
        apiInterface?.getdetails(id)?.enqueue(object : Callback<ProductsItem>{
            override fun onResponse(call: Call<ProductsItem>, response: Response<ProductsItem>) {
                var images = response.body()?.images
                var title = response.body()?.title
                var price = response.body()?.price
                var discountPercentage = response.body()?.discountPercentage
                var description = response.body()?.description
                var stock = response.body()?.stock
                var rating = response.body()?.rating

                var ViewPagerAdapter = ViewPagerAdapter(images)
                binding.vpagesearch.adapter=ViewPagerAdapter
                binding.txtstitle.text=title
                binding.txtsprice.text=price.toString()
                binding.txtsdiscount.text=discountPercentage.toString()
                binding.txtsdescribe.text=description
                binding.txtsstock.text=stock.toString()
                binding.txtsrateing.text=rating.toString()
            }

            override fun onFailure(call: Call<ProductsItem>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}