package com.example.tooo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tooo.R
import com.example.tooo.adapter.PictureAdapter
import com.example.tooo.interfaces.ClickInterface
import com.example.tooo.utils.Constants.TAG

class PictureActivity : AppCompatActivity(), ClickInterface {
    private lateinit var mPictureAdapter: PictureAdapter
    private lateinit var mRcPicView: RecyclerView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        Log.d(TAG, "PictureActivity - onCreate() called") 
        
        mPictureAdapter = PictureAdapter(this)
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
    }




}