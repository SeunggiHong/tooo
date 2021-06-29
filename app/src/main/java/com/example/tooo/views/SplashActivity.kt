package com.example.tooo.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tooo.App
import com.example.tooo.R
import com.example.tooo.utils.Constants.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        App.instance.setTheme(R.style.Splash_Theme)
        setTheme(R.style.Splash_Theme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(TAG, "SplashActivity - onCreate() called")

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            val intent = Intent(App.instance, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SplashActivity - onStart() called") 
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SplashActivity - onResume() called") 
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SplashActivity - onPause() called") 
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SplashActivity - onDestroy() called") 
    }
}