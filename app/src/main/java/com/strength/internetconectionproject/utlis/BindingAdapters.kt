package com.strength.internetconectionproject.utlis

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.strength.internetconectionproject.PhotoGridAdapter
import com.strength.internetconectionproject.R
import com.strength.internetconectionproject.network.MarsData

@BindingAdapter("marsDataList")
fun bindRecycleView(recyclerView: RecyclerView, dataList : List<MarsData>) {
    val adapter = recyclerView.adapter as PhotoGridAdapter

    adapter.submitList(dataList)
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl : String?) {

    imageUrl?.let {urlText ->
        val imageUri = urlText.toUri().buildUpon().scheme("https").build()

        Glide.with(imageView.context)
            .load(imageUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_launcher_foreground)
            )
            .into(imageView)
    }
}