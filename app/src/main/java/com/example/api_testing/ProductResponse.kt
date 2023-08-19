package com.example.api_testing

import com.google.gson.annotations.SerializedName


data class ProductResponse<T>(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("skip")
	val skip: Int? = null,

	@field:SerializedName("products")
	val products: List<ProductsItem?>? = null
)

data class ProductsItem(

	@field:SerializedName("discountPercentage")
	val discountPercentage: Any? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("images")
	val images: List<String?>? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("rating")
	val rating: Any? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("stock")
	val stock: Int? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("brand")
	val brand: String? = null
)
