package com.example.patientmanagementsystem

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.patientmanagementsystem.database.Appointment
import com.example.patientmanagementsystem.database.AppointmentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PatientAdapter(items:List<Appointment>,repository: AppointmentRepository,viewModel: MainActivityData):Adapter<PatientViewHolder>() {

    var context: Context? = null
    val items = items
    val repository = repository
    val viewModel = viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_patient,parent,false)
        context = parent.context
        return PatientViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        holder.cbPatient.text = items.get(position).item

//        val appointment = items[position]
//        holder.cbPatient.text = "${appointment.item} - ${appointment.phoneNumber}"

        holder.ivDelete.setOnClickListener{
            val isChecked = holder.cbPatient.isChecked

            if (isChecked){
                CoroutineScope(Dispatchers.IO).launch {
                    repository.delete(items.get(position))
                    val data =repository.getAllAppointmentItems()
                    withContext(Dispatchers.Main){
                        viewModel.setData(data)
                    }
                }
                Toast.makeText(context,"Item Deleted",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"Select the item to be Deleted",Toast.LENGTH_LONG).show()
            }
        }
    }
}


















