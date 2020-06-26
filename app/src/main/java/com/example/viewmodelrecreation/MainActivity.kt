package com.example.viewmodelrecreation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: CustomViewModel

    lateinit var factory: CustomFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getViewModel(CustomViewModel::class.java, factory)
        setContentView(R.layout.activity_main)
    }


}