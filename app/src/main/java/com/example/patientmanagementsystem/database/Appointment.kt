package com.example.patientmanagementsystem.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Appointment(
    var item:String?,
    //var phoneNumber: String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}
