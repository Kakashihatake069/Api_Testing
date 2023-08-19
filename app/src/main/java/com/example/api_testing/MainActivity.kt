package com.example.api_testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_testing.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var apiInterface: ApiInterface? = null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {

        apiInterface = ApiClient.getClient()?.create(ApiInterface::class.java)

        apiInterface?.getAllproduct()?.enqueue(object : Callback<ProductResponse<Any?>>{
            override fun onResponse(
                call: Call<ProductResponse<Any?>>,
                response: Response<ProductResponse<Any?>>
            ) {

//                for(i in 0 until mainlist?.size!!)
//                {
//                    Log.e("TAG", "onResponse: "+mainlist[i]?.title )
//                }
                var mainlist = response.body()?.products
                var adapter =ProductAdapter(mainlist,this@MainActivity){product->
                    var intent = Intent(this@MainActivity,DisplayProductDetails::class.java)
                    intent.putExtra("id",product.id)
                    startActivity(intent)
                }
                var manager = LinearLayoutManager(this@MainActivity)
                binding.rcvmain.layoutManager = manager
                binding.rcvmain.adapter = adapter
            }

            override fun onFailure(call: Call<ProductResponse<Any?>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}