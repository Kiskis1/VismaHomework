package com.example.vismahomework.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vismahomework.R
import com.example.vismahomework.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFragment.newInstance())
            .commitAllowingStateLoss()
    }
}