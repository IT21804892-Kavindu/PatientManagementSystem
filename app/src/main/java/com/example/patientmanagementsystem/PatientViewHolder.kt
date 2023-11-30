package com.example.patientmanagementsystem

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PatientViewHolder(view:View):ViewHolder(view) {
    val cbPatient: CheckBox = view.findViewById(R.id.cbPatient)
    val ivDelete: ImageView = view.findViewById(R.id.ivDelete)
}