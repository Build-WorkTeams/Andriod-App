package com.example.workteams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.workteams.authentication.SessionManager
import com.example.workteams.databinding.ActivityMainBinding
import com.example.workteams.verification.AuthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        binding.bottomNavView.background = null
//        binding.bottomNavView.menu.getItem(2).isEnabled = false
        setContentView(binding.root)
        // Set Username
        val username = SessionManager.getUsername(this)
        binding.welcomeTv.append(" $username")
        binding.logOutBtn.setOnClickListener {
            logOut()
        }
    }

    private fun logOut() {
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
        SessionManager.clearData(this)
        val intent = Intent(this, AuthActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
//       intent.putExtra(
//            "navigateToLogin",
//            true
//        ) // Optional: Pass any data you need to the target Activity
        GlobalVariables.isLogOutClicked = true
        startActivity(intent)
    }
}