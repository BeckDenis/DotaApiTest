package com.example.dotaapitest

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dotaapitest.network.DotaProperty
import com.example.dotaapitest.overview.HeroListAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val baseImgApi = "https://api.opendota.com"
        val finalImgUrl = "$baseImgApi$imgUrl"
        val imgUri = finalImgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<DotaProperty>?) {
    val adapter = recyclerView.adapter as HeroListAdapter
    adapter.submitList(data)
}