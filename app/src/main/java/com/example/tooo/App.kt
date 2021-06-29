package com.example.tooo

import android.app.Application
import android.util.Log
import com.example.tooo.utils.Constants.TAG
import com.example.tooo.utils.KAKAO_API
import com.kakao.sdk.common.KakaoSdk

class App: Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        KakaoSdk.init(this, KAKAO_API.NATIVE_APP_KEY)

        Log.d(TAG, "App - onCreate() called")
    }
}