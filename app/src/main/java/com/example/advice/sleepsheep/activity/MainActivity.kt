package com.example.advice.sleepsheep

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "SleepSheep"
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        ) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> toast("home clicked")
                R.id.profile -> toast("profile clicked")
                R.id.report-> toast("report clicked")
                R.id.setting-> toast("setting clicked")
                R.id.logout-> updateUI(currentUser)
            }

            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }
    private fun Context.toast(message:String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }

    private fun signOut() {
        auth.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            signOut()
        } else {
            Log.d("TAGLOGOUT", "User Invalid")
        }
    }
}
