package com.example.tooo.viewholder

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tooo.App
import com.example.tooo.R
import com.example.tooo.data.User

import com.example.tooo.utils.Constants.TAG
import com.example.tooo.interfaces.ClickInterface


class CustomViewHolder(view: View, mClickInterface: ClickInterface) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private val userPhoto: ImageView
    private val userName: TextView
    private val userEmail: TextView
    private val userPhone: TextView
    private var mClickInterface: ClickInterface? = null

    init {
        Log.d(TAG, "CustomViewHolder init")
        userPhoto = view.findViewById(R.id.iv_user)
        userName = view.findViewById(R.id.tv_username)
        userEmail = view.findViewById(R.id.tv_usermail)
        userPhone = view.findViewById(R.id.tv_phone)

        itemView.setOnClickListener(this)
        this.mClickInterface = mClickInterface
    }

    fun bindViewHolder(user: User) {
        Log.d(TAG, "bindViewHolder: bind")
        this.userName.text = user.userName
        this.userEmail.text = user.userEmail
        this.userPhone.text = user.userPhone

        Glide.with(App.instance)
            .load(user.userPhoto)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(this.userPhoto)

    }

    override fun onClick(v: View?) {
        this.mClickInterface?.onItemClicked(adapterPosition)
    }


}