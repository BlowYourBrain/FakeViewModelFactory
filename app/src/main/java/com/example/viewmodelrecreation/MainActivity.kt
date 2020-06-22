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

        try {
            viewModel = ViewModelProvider(this, FakeFactory).get(CustomViewModel::class.java)
            Log.d("fuck", "successfully get viewModel with FakeFactory")
        } catch (e: FakeFactory.FakeFactoryException) {
            factory = CustomFactory()
            viewModel = ViewModelProvider(this, factory).get(CustomViewModel::class.java)
            Log.d("fuck", "successfully get viewModel with factory")
        }

        Log.d("fuck", "uuid = ${viewModel.someString}, instance = $viewModel")

        setContentView(R.layout.activity_main)
    }


}