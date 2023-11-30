package com.example.patientmanagementsystem.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Appointment::class], version = 1)
abstract class AppointmentDatabase:RoomDatabase() {
    abstract fun getAppointmentDao():AppointmentDao

    companion object{
        @Volatile
        private var INSTANCE:AppointmentDatabase? = null

        fun getInstance(context:Context):AppointmentDatabase{
            synchronized(this){
                return INSTANCE?:Room.databaseBuilder(
                    context,
                    AppointmentDatabase::class.java,
                    "appointment_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}