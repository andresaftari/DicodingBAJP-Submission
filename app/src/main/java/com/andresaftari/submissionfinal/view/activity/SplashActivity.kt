package com.andresaftari.submissionfinal.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andresaftari.submissionfinal.R
import java.lang.Exception

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.title = null

        val splashScreen = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                    startActivity(Intent(baseContext, HomeActivity::class.java))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        splashScreen.start()
    }
}