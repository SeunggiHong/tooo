package com.example.tooo.viewholder

import android.util.Log
import android.view.View
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tooo.App
import com.example.tooo.R
import com.example.tooo.data.Picture
import com.example.tooo.data.User
import com.example.tooo.interfaces.ClickInterface
import com.example.tooo.utils.Constants

class PictureViewHolder(view: View, mClickInterface: ClickInterface) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private val userPhoto: ImageView
    private var mClickInterface: ClickInterface? = null

    init {
        Log.d(Constants.TAG, "PictureViewHolder init")
        userPhoto = view.findViewById(R.id.iv_user)

        itemView.setOnClickListener(this)
        this.mClickInterface = mClickInterface
    }

    fun bindViewHolder(pic: Picture) {
        Log.d(Constants.TAG, "bindViewHolder: bind")

        Glide.with(App.instance)
            .load(pic.url)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(this.userPhoto)

    }

    override fun onClick(v: View?) {
        this.mClickInterface?.onItemClicked(adapterPosition)
    }


}