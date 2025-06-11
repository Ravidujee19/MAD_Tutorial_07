package com.example.tute07

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.button)
        val button2:Button = findViewById(R.id.button2)

        button.setOnClickListener {
            loadHome()
        }
        button2.setOnClickListener {
            loadSettings()
        }
    }

    private fun loadHome(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,homeFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,homeFragment).commit()
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