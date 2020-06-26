package com.example.viewmodelrecreation

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

object FakeFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        throw FakeFactoryException("fake factory invokes exception on create $modelClass")
    }

    class FakeFactoryException(message: String) : Throwable(message)

}

fun <T : ViewModel> ViewModelStoreOwner.getViewModel(modelClass: Class<T>, factory: ViewModelProvider.Factory): T {
    return try {
        ViewModelProvider(this, FakeFactory).get(modelClass)
    } catch (e: FakeFactory.FakeFactoryException) {
        ViewModelProvider(this, factory).get(modelClass)
    }
}