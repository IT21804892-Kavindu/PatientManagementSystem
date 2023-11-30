package com.example.patientmanagementsystem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.patientmanagementsystem.database.Appointment

class MainActivityData:ViewModel() {
    private val _data = MutableLiveData<List<Appointment>>()

    val data:LiveData<List<Appointment>> = _data

    fun setData(data: List<Appointment>){
        _data.value = data
    }
}