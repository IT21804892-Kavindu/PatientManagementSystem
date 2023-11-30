package com.example.patientmanagementsystem.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppointmentDao {
    @Insert
    suspend fun insert(appointment: Appointment)

    @Delete
    suspend fun delete(appointment: Appointment)

    @Query("SELECT * FROM Appointment")
    fun getAllAppointmentItems():List<Appointment>

//    @Query("UPDATE Appointment SET phoneNumber = :phoneNumber WHERE id = :appointmentId")
//    suspend fun updatePhoneNumber(appointmentId: Int, phoneNumber: String)
}