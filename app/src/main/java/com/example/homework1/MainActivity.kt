package com.example.homework1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework1.utils.Constants

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

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val service = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if (service is PlateFragment){
          if(savedInstanceState == null) service.listSize = persistentState?.getInt(Constants.GET_INFO_FROM_PERSISTENT)?:0
            else{
              service.listSize = savedInstanceState.getInt(Constants.GET_INFO_FROM_INSTANCE)
          }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        val service = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if (service is PlateFragment){
            outState.putInt(Constants.GET_INFO_FROM_INSTANCE, service.listSize)
            outPersistentState.putInt(Constants.GET_INFO_FROM_PERSISTENT, service.listSize)
        }
        super.onSaveInstanceState(outState, outPersistentState)
    }
}