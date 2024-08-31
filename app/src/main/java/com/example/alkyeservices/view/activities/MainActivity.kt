package com.example.alkyeservices.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.daggerhiltdemoapp.R
import com.example.daggerhiltdemoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setupWithNavController(
            findNavController(R.id.container)
        )

        bottomNavigationChangedListener(findNavController(R.id.container))
    }

    /**
     * Here we handle the click on bottom navigation tab
     */
    private fun bottomNavigationChangedListener(navController: NavController) {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            val isMenuFragment = destination.id == R.id.home_fragment
                    || destination.id == R.id.bookmark_fragment
                    || destination.id == R.id.tv_fragment
                    || destination.id == R.id.notification_fragment
                    || destination.id == R.id.profile_fragment

            if (isMenuFragment) {

                lifecycleScope.launch {
                    delay(100)
                    binding.bottomNavigation.visibility = View.VISIBLE
                }

            } else  {
                lifecycleScope.launch {
                    delay(100)
                    binding.bottomNavigation.visibility= View.GONE
                }
            }
        }

    }

}