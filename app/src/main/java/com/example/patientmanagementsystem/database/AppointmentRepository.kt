package com.example.patientmanagementsystem.database

class AppointmentRepository (private val db:AppointmentDatabase){
    suspend fun insert(appointment: Appointment) = db.getAppointmentDao().insert(appointment)
    suspend fun delete(appointment: Appointment) = db.getAppointmentDao().delete(appointment)

    fun getAllAppointmentItems():List<Appointment> = db.getAppointmentDao().getAllAppointmentItems()

}