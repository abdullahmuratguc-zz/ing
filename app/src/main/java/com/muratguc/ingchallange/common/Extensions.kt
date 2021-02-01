package com.muratguc.ingchallange.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.muratguc.ingchallange.R

/**
 * Created by Murat Güç on 2/1/2021.
 */

@BindingAdapter("url")
fun setImageUrl(view: ImageView, url: String?) {
    Glide.with(view).load(url)
        .placeholder(R.mipmap.ic_launcher)
        .into(view)
}