package com.example.workteams.verification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.workteams.R
import com.example.workteams.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root
//        view.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        // Retrieve the data passed from the source Activity
//        intent?.let {
//            val data = it.getBooleanExtra("navigateToLogin", false)
//            // Use the boolean value stored in 'data' here
//            // Determine which Fragment to display based on the data
//            val fragment = when (data) {
//                true -> {
//                    findNavController(R.id.action_welcomeScreen_to_loginFragment)
//                }
//
//                else -> {
//                    TODO()
//                }
//            }
//        }



        setContentView(view)
//        setContentView(R.layout.practice)
    }

    override fun onSupportNavigateUp(): Boolean {
        navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}