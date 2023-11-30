package com.example.patientmanagementsystem

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {

    private val homeFragement = HomeFragement()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnEmergency: Button = findViewById(R.id.btnEmergency)
        val ivHome:ImageView = findViewById(R.id.ivHome)
        val ivList:ImageView = findViewById(R.id.ivList)
        val ivSettings:ImageView = findViewById(R.id.ivSettings)

        btnEmergency.setOnClickListener{
            //implicit intent to open the dialler with a number
            val number = "+94117123456"
            val uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }
        ivHome.setOnClickListener{
            loadHome()
        }
        ivList.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        ivSettings.setOnClickListener{
            loadSettings()
        }

    }
    private fun loadHome(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,homeFragement).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,homeFragement).commit()
        }
    }
    private fun loadSettings(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,settingsFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,settingsFragment).commit()
        }
    }
}