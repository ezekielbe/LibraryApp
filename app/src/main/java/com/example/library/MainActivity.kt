package com.example.library

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.library.dashboard.DashboardActivity

class MainActivity : AppCompatActivity() {
    private lateinit var loginBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loginBtn = findViewById(R.id.button)
        loginBtn.setOnClickListener {
            val username = "sampleUser"
            val privilege = "user"
            val intent = Intent(this, DashboardActivity::class.java).apply {
                putExtra("username", username)
                putExtra("privilege", privilege)
            }
            startActivity(intent)
        }
    }
}