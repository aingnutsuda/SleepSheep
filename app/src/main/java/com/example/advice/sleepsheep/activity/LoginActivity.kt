package com.example.advice.sleepsheep

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.advice.sleepsheep.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initInstances()
    }

    private fun initInstances() {
        setSupportActionBar(toolbar_login)
    }
}
