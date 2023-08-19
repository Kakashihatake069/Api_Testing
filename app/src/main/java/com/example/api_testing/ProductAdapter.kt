package com.example.api_testing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(var datalist: List<ProductsItem?>?, var context: MainActivity,var click :(ProductsItem)-> Unit): RecyclerView.Adapter<ProductAdapter.MyViewholder>() {
    class MyViewholder(itemview:View):RecyclerView.ViewHolder(itemview) {

        var txtid: TextView = itemview.findViewById(R.id.txtid)
        var txtbrand: TextView = itemview.findViewById(R.id.txtbrand)
        var imgthumbnail: ImageView = itemview.findViewById(R.id.imgthumbnail)
        var loutproductitem : LinearLayout = itemview.findViewById(R.id.loutproductitem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.MyViewholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.productitemfile, null, false)
        val adapter = MyViewholder(view)
        return adapter
    }

    override fun onBindViewHolder(holder: ProductAdapter.MyViewholder, position: Int) {
        holder.txtid.setText(datalist!!.get(position)?.id.toString())
//        holder.txttitle.setText(datalist[position].title)
        holder.txtbrand.setText(datalist!!.get(position)?.brand)

        Glide.with(context) .load("https://i.dummyjson.com/data/products/${datalist!![position]?.id}/thumbnail.jpg")
            .into(holder.imgthumbnail)

        holder.loutproductitem.setOnClickListener {
                click.invoke(datalist!![position]!!)
        }

    }

    override fun getItemCount(): Int {
        return datalist!!.size
    }
}