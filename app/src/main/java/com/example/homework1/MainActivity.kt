package com.example.homework1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = PlateFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, fragment)
                .commit()
        }
    }
}