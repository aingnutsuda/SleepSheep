package com.example.advice.sleepsheep

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth

class Mainfragment: Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)

        if (savedInstanceState != null) {
            onViewStateRestored(savedInstanceState) // Restore Instance State
        }

        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(
            R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance(view, savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        // Initialize Fragment Items
    }

    private fun initInstance(rootView: View?, savedInstanceState: Bundle?) {
        // Init 'View' instance(s) with rootView.findViewById here
    }
}