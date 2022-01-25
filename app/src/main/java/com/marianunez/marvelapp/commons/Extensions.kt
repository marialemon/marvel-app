package com.marianunez.marvelapp.commons

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageByUrl(url: String) {

    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)

}