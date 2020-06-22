package com.example.viewmodelrecreation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object FakeFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        throw FakeFactoryException("fake factory invokes exception on create $modelClass")
    }

    class FakeFactoryException(message: String) : Throwable(message)

}