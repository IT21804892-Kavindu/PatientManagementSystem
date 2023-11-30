package com.example.patientmanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.patientmanagementsystem.database.Appointment
import com.example.patientmanagementsystem.database.AppointmentDatabase
import com.example.patientmanagementsystem.database.AppointmentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:PatientAdapter
    private lateinit var viewModel:MainActivityData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rvPatientList)
        val repository = AppointmentRepository(AppointmentDatabase.getInstance(this))
        viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        viewModel.data.observe(this){
            adapter = PatientAdapter(it,repository,viewModel)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getAllAppointmentItems()

            runOnUiThread{
                viewModel.setData(data)
            }
        }
        val addAppointment:Button = findViewById(R.id.btnAddPatient)

        addAppointment.setOnClickListener{
            displayAlert(repository)
        }

    }
    private fun displayAlert(repository:AppointmentRepository){
        val builder = AlertDialog.Builder(this)

        // Set the alert dialog title and message
        builder.setTitle(getString(R.string.AlertTitle))
        builder.setMessage((R.string.SetAppointment))

        // Create an EditText input field

        val input = EditText(this)
//        val inputAppointment = EditText(this)  //
//        val inputPhoneNumber = EditText(this)  //
        input.inputType = InputType.TYPE_CLASS_TEXT
//        inputAppointment.inputType = InputType.TYPE_CLASS_TEXT //
//        inputPhoneNumber.inputType = InputType.TYPE_CLASS_PHONE  //
        builder.setView(input)
//        builder.setView(inputAppointment)  //
//        builder.setView(inputPhoneNumber)  //

        // Set the positive button action
        builder.setPositiveButton("OK") { dialog, which ->
            // Get the input text and display a Toast message

            val item = input.text.toString()
//            val item = inputAppointment.text.toString()  //
//            val phoneNumber = inputPhoneNumber.text.toString()  //

            CoroutineScope(Dispatchers.IO).launch {
                repository.insert(Appointment(item))
                val data = repository.getAllAppointmentItems()
                runOnUiThread{
                    viewModel.setData(data)
                }
            }
        }
        // Set the negative button action
        builder.setNegativeButton("Cancel") { dialog, which -> dialog.cancel()
        }
        // Create and show the alert dialog
        val alertDialog = builder.create()
        alertDialog.show()

    }
}











