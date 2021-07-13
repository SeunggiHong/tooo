package com.example.tooo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tooo.R
import com.example.tooo.data.Picture

import com.example.tooo.data.User
import com.example.tooo.viewholder.CustomViewHolder
import com.example.tooo.interfaces.ClickInterface
import com.example.tooo.viewholder.PictureViewHolder

class PictureAdapter(pics: ArrayList<Picture>, mClickInterface : ClickInterface) : RecyclerView.Adapter<PictureViewHolder>() {

    private var mClickInterface: ClickInterface? = null
    private var pics: ArrayList<Picture> = ArrayList()

    init {
        this.mClickInterface = mClickInterface
        this.pics = pics

//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874861.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874766.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
//        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_pic_item, parent, false),
            this.mClickInterface!!
        )
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bindViewHolder(pics[position])
    }

    override fun getItemCount(): Int {
        return pics.size
    }

}