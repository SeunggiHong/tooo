package com.example.tooo.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.tooo.App
import com.example.tooo.R
import com.example.tooo.data.User
import com.example.tooo.utils.Constants.TAG
import com.example.tooo.utils.EXTRAS.EXTRA_USER_ID
import com.example.tooo.utils.EXTRAS.EXTRA_USER_NAME
import com.example.tooo.utils.EXTRAS.EXTRA_USER_PHONE
import com.example.tooo.viewmodel.UserViewModel
import com.google.android.material.button.MaterialButton
import com.nhn.android.naverlogin.data.OAuthLoginData

class AddActivity : AppCompatActivity() {

    private lateinit var userViewmodel: UserViewModel
    private var mId: Long? = null
    private var mStrUrl: String = ""
    lateinit var mIvPic: ImageView
    lateinit var mEtName: EditText
    lateinit var mEtMail: EditText
    lateinit var mEtPhone: EditText
    lateinit var mBtnAdd: MaterialButton
    lateinit var mBtnPic: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        Log.d(TAG, "AddActivity - onCreate() called")

        mIvPic = findViewById(R.id.iv_face)
        mEtName = findViewById(R.id.et_add_name)
        mEtMail = findViewById(R.id.et_add_email)
        mEtPhone = findViewById(R.id.et_add_phone)
        mBtnAdd = findViewById(R.id.btn_add)
        mBtnPic = findViewById(R.id.btn_picsel)

        userViewmodel = ViewModelProvider(this).get(UserViewModel::class.java)

        // intent null check & get extras
        if (intent != null && intent.hasExtra(EXTRA_USER_NAME) && intent.hasExtra(EXTRA_USER_PHONE) && intent.hasExtra(EXTRA_USER_ID)) {
            mEtName.setText(intent.getStringExtra(EXTRA_USER_NAME))
            mEtPhone.setText(intent.getStringExtra(EXTRA_USER_PHONE))
            mId = intent.getLongExtra(EXTRA_USER_ID, -1)
        }

        mBtnAdd.setOnClickListener {
            Log.d(TAG, "mBtnAdd tabbed!!")
            val mName  = mEtName.text.toString().trim()
            val mPhone = mEtPhone.text.toString()
            val mPhoto = mStrUrl
            val mEmail = mEtMail.text.toString().trim()
            Log.d(TAG, "Name: $mName \n")

            if(mName.isEmpty() || mPhone.isEmpty()) {
                Toast.makeText(this, "please..", Toast.LENGTH_SHORT).show()
            } else {
                val mInit = mName[0].toUpperCase()
                val user = User(mId, mPhoto, mName, mEmail, mPhone)
                userViewmodel.insert(user)
                finish()
            }
        }

        mBtnPic.setOnClickListener {
            val intent = Intent(App.instance, PictureActivity::class.java)
            startActivity(intent)

            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AddActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AddActivity - onResume() called")

        if (intent.hasExtra("url"))
        {
            val mUrl = intent.getStringExtra("url")
            Log.d(TAG, "url : $mUrl")

            Glide.with(App.instance)
                .load(mUrl)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(this.mIvPic)

            mStrUrl = mUrl!!
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "AddActivity - onPause() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AddActivity - onDestroy() called")
    }

}