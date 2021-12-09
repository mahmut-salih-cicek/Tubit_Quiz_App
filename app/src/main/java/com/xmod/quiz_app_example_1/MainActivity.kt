package com.xmod.quiz_app_example_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()



        var countDownTimer = object :  CountDownTimer(1500,1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                var intent = Intent(this@MainActivity,UserActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        countDownTimer.start()

    }


}