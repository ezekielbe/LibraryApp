package com.example.library.dashboard

import com.example.library.R
import com.example.library.fragments.DisplayFragment
import com.example.library.fragments.LeftUserFragment



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val username = intent.getStringExtra("username")?: ""
        val privilege = intent.getStringExtra("privilege")?: ""

        supportFragmentManager.beginTransaction().replace(R.id.leftpanel, LeftUserFragment()).commit()




    }
}
