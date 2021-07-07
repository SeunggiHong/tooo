package com.example.tooo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tooo.R
import com.example.tooo.data.User
import com.example.tooo.utils.Constants.TAG
import com.example.tooo.utils.EXTRAS.EXTRA_USER_ID
import com.example.tooo.utils.EXTRAS.EXTRA_USER_NAME
import com.example.tooo.utils.EXTRAS.EXTRA_USER_PHONE
import com.example.tooo.viewmodel.UserViewModel

class AddActivity : AppCompatActivity() {

    private lateinit var userViewmodel: UserViewModel
    private var mId: Long? = null

    lateinit var mEtName: EditText
    lateinit var mEtPhoto: EditText
    lateinit var mEtMail: EditText
    lateinit var mEtPhone: EditText
    lateinit var mBtnAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        mEtName = findViewById(R.id.et_add_name)
        mEtPhone = findViewById(R.id.et_add_phone)
        mBtnAdd = findViewById(R.id.btn_add)

        userViewmodel = ViewModelProvider(this).get(UserViewModel::class.java)

        // intent null check & get extras
        if (intent != null && intent.hasExtra(EXTRA_USER_NAME) && intent.hasExtra(EXTRA_USER_PHONE) && intent.hasExtra(EXTRA_USER_ID)) {
            mEtName.setText(intent.getStringExtra(EXTRA_USER_NAME))
            mEtPhone.setText(intent.getStringExtra(EXTRA_USER_PHONE))
            mId = intent.getLongExtra(EXTRA_USER_ID, -1)
        }

        mBtnAdd.setOnClickListener {
            Log.d(TAG, "mBtnAdd tabbed!!")
            val mName = mEtName.text.toString().trim()
            val mPhone = mEtPhone.text.toString()
            val mPhoto = "https://image.flaticon.com/icons/png/512/4874/4874804.png"
            val mEmail = "test@hanmail.com"
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

    }


}