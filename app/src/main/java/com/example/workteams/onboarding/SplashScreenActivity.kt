package com.example.workteams.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.workteams.MainActivity
import com.example.workteams.R
import com.example.workteams.authentication.SessionManager
import com.example.workteams.verification.AuthActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        Navigate to new screen after 3 seconds delay
         */
        Handler(Looper.getMainLooper()).postDelayed({
            val token = SessionManager.getToken(this)
            if (!token.isNullOrBlank()) {
                navigateToHome()
            } else {
                navigateToWelcome()
            }
        }, 3000)
        //
        setContentView(R.layout.activity_splash_screen)
    }

    private fun navigateToHome() {
        val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }

    private fun navigateToWelcome() {
        val intent = Intent(this@SplashScreenActivity, AuthActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }
}