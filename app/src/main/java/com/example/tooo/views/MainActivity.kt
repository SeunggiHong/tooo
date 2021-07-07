package com.example.tooo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tooo.R
import com.example.tooo.adapter.CustomAdapter
import com.example.tooo.data.User
import com.example.tooo.viewmodel.UserViewModel
import com.kakao.sdk.common.util.Utility
import com.example.tooo.interfaces.ClickInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ClickInterface {
    private lateinit var mCustomAdapter: CustomAdapter
    private lateinit var userViewModel: UserViewModel
    var userList = ArrayList<User>()

    init {
        userList.add(User(10002000203,"https://image.flaticon.com/icons/png/512/4874/4874907.png", "seunggiHong", "tmdrl1026@naver.com", "010-1234-4552"))
        userList.add(User(12312312312,"https://image.flaticon.com/icons/png/512/4874/4874861.png", "minJeoungKim", "kim2123@naver.com", "010-1234-4557"))
        userList.add(User(1234123412341,"https://image.flaticon.com/icons/png/512/4874/4874804.png", "Jin Yang", "yddd1213@gmail.com", "010-1234-4557"))
        userList.add(User(12341234134,"https://image.flaticon.com/icons/png/512/4874/4874766.png", "minsooPark", "adf22@naver.com", "010-1234-4557"))
        userList.add(User(12341324,"https://image.flaticon.com/icons/png/512/3048/3048122.png", "mooYaho", "mooYaho@gmail.com", "010-1234-4557"))
        userList.add(User(123412341234,"https://image.flaticon.com/icons/png/512/3048/3048163.png", "chaemiSin", "sin11231@gmail.com", "010-1234-2323"))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val keyHash = Utility.getKeyHash(this)
        Log.d("logMsg", keyHash)

        initView()

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.getAll().observe(this, Observer<List<User>> {

        })

    }

    fun initView() {
        mCustomAdapter = CustomAdapter(userList,this)
        rc_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mCustomAdapter
        }
    }

    override fun onItemClicked(pos: Int) {
        Toast.makeText(this,"position = $pos" ,Toast.LENGTH_SHORT).show()
    }
}
