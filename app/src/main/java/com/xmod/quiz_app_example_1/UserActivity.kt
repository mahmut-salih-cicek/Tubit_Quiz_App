package com.xmod.quiz_app_example_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UserActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        supportActionBar?.hide()



    }


    fun goQuizActivity (view: View){
        var intent =  Intent(this@UserActivity,QuizActivity::class.java)
        startActivity(intent)
        finish()
    }



}