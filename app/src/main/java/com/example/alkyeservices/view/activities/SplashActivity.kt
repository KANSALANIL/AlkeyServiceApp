package com.example.alkyeservices.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.daggerhiltdemoapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        goToNext()
    }

    private fun goToNext() {
        lifecycleScope.launch {
            delay(2000)
            val toHomePage = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(toHomePage)
            finish()

        }
    }

}