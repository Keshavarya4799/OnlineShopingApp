package com.karya.onlineshoping

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private var TAG :String = "Coroutine"

    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                delay(500)
//    yield()
                Log.d(TAG, "View Model Scope")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"View model Destroyed")
    }
}