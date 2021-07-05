package com.example.tooo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tooo.R
import com.example.tooo.adapter.CustomAdapter
import com.example.tooo.data.User
import com.example.tooo.interfaces.ClickInterface
import com.example.tooo.viewmodel.UserViewModel
import com.kakao.sdk.common.util.Utility

class MainActivity : AppCompatActivity(), ClickInterface {
    private lateinit var mCustomAdapter: CustomAdapter
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val keyHash = Utility.getKeyHash(this)
        Log.d("logMsg", keyHash)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.getAll().observe(this, Observer<List<User>> {

        })

    }

    override fun onItemClicked(pos: Int) {
        TODO("Not yet implemented")
    }
}
