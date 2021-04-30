package com.example.epass.presentation.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.epass.databinding.ActivityEditPassBinding

class EditActivity : AppCompatActivity() {
    private lateinit var bining:ActivityEditPassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bining = ActivityEditPassBinding.inflate(layoutInflater)
        setContentView(bining.root)

        bining.btnBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })

        bining.btnReady.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}