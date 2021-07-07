package com.example.tooo.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.tooo.App
import com.example.tooo.R
import com.example.tooo.utils.API.NAVER_CLIENT_ID
import com.example.tooo.utils.API.NAVER_CLIENT_SECRET
import com.example.tooo.utils.Constants.APP_NAME
import com.example.tooo.utils.Constants.TAG
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.nhn.android.naverlogin.OAuthLogin
import com.nhn.android.naverlogin.OAuthLoginHandler
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton

class LoginActivity : AppCompatActivity() {
    lateinit var mBtnLogin: Button
    lateinit var mBtnKakao: ImageButton
    lateinit var mBtnNaver: OAuthLoginButton
    lateinit var mOAuthLoginModule: OAuthLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(TAG, "LoginActivity - onCreate() called")

        mBtnLogin = findViewById(R.id.btn_login)
        mBtnKakao = findViewById(R.id.btn_kakao)
        mBtnNaver = findViewById(R.id.btn_naver)

        //기본 로그인
        mBtnLogin.setOnClickListener {
            val intent = Intent(App.instance, MainActivity::class.java)
            startActivity(intent)
        }

        // 로그인 공통 callback 구성
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e(TAG, "로그인 실패", error)
            }
            else if (token != null) {
                Log.i(TAG, "로그인 성공 ${token.accessToken}")
                val intent = Intent(App.instance, MainActivity::class.java)
                startActivity(intent)
            }
        }

        mBtnKakao.setOnClickListener {
            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }

        mOAuthLoginModule = OAuthLogin.getInstance()
        mOAuthLoginModule.init(
            this,
            NAVER_CLIENT_ID,
            NAVER_CLIENT_SECRET,
            APP_NAME
        )
        mBtnNaver.setOAuthLoginHandler(mOAuthLoginHandler)
    }

    val mOAuthLoginHandler: OAuthLoginHandler = object : OAuthLoginHandler() {
        override fun run(success: Boolean) {
            if (success) {
                val accessToken: String = mOAuthLoginModule.getAccessToken(baseContext)
                val refreshToken: String = mOAuthLoginModule.getRefreshToken(baseContext)
                val expiresAt: Long = mOAuthLoginModule.getExpiresAt(baseContext)
                val tokenType: String = mOAuthLoginModule.getTokenType(baseContext)
                Log.d(TAG, "LoginActivity - run() success accessToken : {$accessToken} refreshToken : {$refreshToken")

                val intent = Intent(App.instance, MainActivity::class.java)
                startActivity(intent)
            } else {
                val errorCode: String = mOAuthLoginModule.getLastErrorCode(App.instance).code
                val errorDesc = mOAuthLoginModule.getLastErrorDesc(App.instance)
                Toast.makeText(App.instance, "errorCode: $errorCode + errorDesc: + errorDesc ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "LoginActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "LoginActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "LoginActivity - onPause() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "LoginActivity - onDestroy() called")
    }


}