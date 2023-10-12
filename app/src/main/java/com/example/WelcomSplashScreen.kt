package com.example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask

class WelcomSplashScreen : AppCompatActivity() {

    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_splash_screen)

        // Start a timer to delay the launch of the main activity
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // Cancel the timer
                timer.cancel()

                // Start the main activity
                startActivity(Intent(this@WelcomSplashScreen, MainActivity::class.java))
                finish()
            }
        }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Cancel the timer if it is still running
        if (timer != null) {
            timer.cancel()
        }
    }
}