package com.`fun`.nbucurrency.modules.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.`fun`.nbucurrency.R
import com.`fun`.nbucurrency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.viewModel = mainViewModel
        mainViewModel.onBind()
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.onStart()
    }

    override fun onStop() {
        super.onStop()
        mainViewModel.onStop()
    }

    override fun onDestroy() {
        mainViewModel.onUnBind()
        mainViewModel.onDestroy()
        super.onDestroy()
    }

}
