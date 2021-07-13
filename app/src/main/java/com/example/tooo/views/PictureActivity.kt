package com.example.tooo.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tooo.R
import com.example.tooo.adapter.PictureAdapter
import com.example.tooo.data.Picture
import com.example.tooo.interfaces.ClickInterface
import com.example.tooo.utils.Constants.TAG

class PictureActivity : AppCompatActivity(), ClickInterface {
    private lateinit var mPictureAdapter: PictureAdapter
    private lateinit var mRcPicView: RecyclerView
    private var pics: ArrayList<Picture> = ArrayList()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        Log.d(TAG, "PictureActivity - onCreate() called")

        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874861.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874766.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874907.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
        pics.add(Picture("https://image.flaticon.com/icons/png/512/4874/4874804.png"))
        
        mPictureAdapter = PictureAdapter(pics,this)
        mRcPicView = findViewById(R.id.rc_pic_view)
        mRcPicView.apply {
            layoutManager = GridLayoutManager(this@PictureActivity, 3)
            adapter = mPictureAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "PictureActivity - onStart() called") 
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "PictureActivity - onResume() called") 
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "PictureActivity - onPause() called") 
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "PictureActivity - onDestroy() called") 
    }

    override fun onItemClicked(pos: Int) {
        Log.d(TAG, "PictureActivity - onItemClicked() called")
        Log.d(TAG, "pos $pos")
        Toast.makeText(this, "pos? : $pos", Toast.LENGTH_SHORT).show()

        finish()
        var intent = Intent(this, AddActivity::class.java)
        intent.putExtra("url", pics[pos].url)
        startActivity(intent)


    }




}