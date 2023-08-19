package com.example.api_testing

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/products")
    fun getAllproduct(): Call<ProductResponse<Any?>>

    @GET("products/{id}")
    fun getdetails(
        @Path("id") id:Int
    ): Call<ProductsItem>

}