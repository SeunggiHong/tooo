package com.example.tooo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tooo.R
import com.example.tooo.interfaces.ClickInterface
import com.example.tooo.data.User
import com.example.tooo.viewholder.CustomViewHolder

class CustomAdapter(private val dataSet: ArrayList<User>, mClickInterface :ClickInterface) : RecyclerView.Adapter<CustomViewHolder>() {

    private var mClickInterface: ClickInterface? = null

    init {
        this.mClickInterface = mClickInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false),
            this.mClickInterface!!
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindViewHolder(dataSet[position])
//        holder.itemView.setOnClickListener {
//            val intent: Intent = Intent(it.context, ProfileActivity::class.java)
//            intent.apply {
//                putExtra("pic", dataSet[position].userPhoto)
//                putExtra("name", dataSet[position].userName)
//                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            }
//            it.context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}