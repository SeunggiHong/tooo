package com.example.tooo.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tooo.App
import com.example.tooo.R
import com.example.tooo.adapter.CustomAdapter
import com.example.tooo.data.User
import com.example.tooo.viewmodel.UserViewModel
import com.kakao.sdk.common.util.Utility
import com.example.tooo.interfaces.ClickInterface
import com.example.tooo.utils.Constants.TAG
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ClickInterface {
    private lateinit var mCustomAdapter: CustomAdapter
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var mRcView: RecyclerView
    private lateinit var mFabMenu: FloatingActionButton
    private lateinit var mFabAdd: FloatingActionButton
    private lateinit var mFabDel: FloatingActionButton

    private lateinit var mOpenAnim: Animation
    private lateinit var mCloseAnim: Animation
    private lateinit var mClockAnim: Animation
    private lateinit var mAntiClockAnim: Animation

    private var mIsOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called")

        val keyHash = Utility.getKeyHash(this)
        Log.d("logMsg", keyHash)

        mCustomAdapter = CustomAdapter(this)
        mRcView = findViewById(R.id.rc_view)
        mRcView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mCustomAdapter
        }

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.getAll().observe(this, Observer<List<User>> { it ->
            mCustomAdapter.setDatas(it)
        })

        mOpenAnim = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        mCloseAnim = AnimationUtils.loadAnimation(this, R.anim.fab_close)
        mClockAnim = AnimationUtils.loadAnimation(this, R.anim.fab_clockwise)
        mAntiClockAnim = AnimationUtils.loadAnimation(this, R.anim.fab_anti_clockwise)

        mFabMenu = findViewById(R.id.fab_menu)
        mFabAdd = findViewById(R.id.fab_add)
        mFabDel = findViewById(R.id.fab_del)

        mFabMenu.setOnClickListener {
            if(mIsOpen){
                mFabAdd.startAnimation(mCloseAnim)
                mFabDel.startAnimation(mCloseAnim)
                mFabMenu.startAnimation(mClockAnim)
                mIsOpen = false
            } else {
                mFabAdd.startAnimation(mOpenAnim)
                mFabDel.startAnimation(mOpenAnim)
                mFabMenu.startAnimation(mAntiClockAnim)
                mFabAdd.isClickable
                mFabDel.isClickable
                mIsOpen = true
            }
        }

        mFabAdd.setOnClickListener{
            Log.d(TAG, "mFabAdd tabbed!!")
            val intent = Intent(App.instance, AddActivity::class.java)
            startActivity(intent)
        }

        mFabDel.setOnClickListener {
            val intent = Intent(App.instance, DeleteActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity - onPause() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity - onDestroy() called")
    }

    override fun onItemClicked(pos: Int) {
        Toast.makeText(this,"position = $pos" ,Toast.LENGTH_SHORT).show()
    }
}
