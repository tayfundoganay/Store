package com.example.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.data.model.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.MyHolderView>() {

    var liveData: List<Product>? = null

    fun setList(data: List<Product>) {
        this.liveData = data
    }

    class MyHolderView(view: View) : RecyclerView.ViewHolder(view) {
        val productTitle: TextView = view.findViewById(R.id.productTitle)
        val productPrice: TextView = view.findViewById(R.id.productPrice)
        //val productRating: TextView = view.findViewById(R.id.productRatingBar)
        val productDescription: TextView = view.findViewById(R.id.productDescription)
        //val productCategory: TextView = view.findViewById(R.id.productCategory)
        fun bindItems(product: Product) {

            //productTitle.text = post.productTitle
            //productPrice.text = post.productPrice.toString()
            //productDescription.text = post.productDescription


            //productImage
            productTitle.text = product.productTitle
            productPrice.text = product.productPrice.toString()
            //productRatingBar
            //productReviewCount
            productDescription.text = product.productDescription
            //productCategory.text = product.productCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.MyHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyHolderView(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.MyHolderView, position: Int) {
        holder.bindItems(liveData!!.get(position))
    }

    override fun getItemCount(): Int {
        if (liveData == null)
            return 0
        else
            return liveData!!.size
    }
}