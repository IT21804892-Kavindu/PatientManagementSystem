package com.example.patientmanagementsystem

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel:ViewModel() {
    private val backgroundColor = MutableLiveData<Int>()

    fun getBackgroundColor(): LiveData<Int> {
        return backgroundColor
    }
    fun setBackgroundColor(color: Int){
        backgroundColor.value = color
    }
}