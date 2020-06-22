package com.example.viewmodelrecreation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.*

class CustomFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CustomViewModel(UUID.randomUUID().toString()) as T
    }

}