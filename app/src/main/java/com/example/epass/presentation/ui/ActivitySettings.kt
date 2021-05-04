package com.example.epass.presentation.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.epass.databinding.ActivitySettingsBinding

class ActivitySettings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingsBinding.inflate(layoutInflater)
        
        setContentView(binding.root)

        binding.btnBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })

        binding.rate.setOnClickListener(View.OnClickListener {

        })

        binding.lang.setOnClickListener(View.OnClickListener {
            val dialog = CustomDialogFr_lan()
            dialog.dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show(supportFragmentManager,"dialog language")

        })

        binding.theme.setOnClickListener(View.OnClickListener {
            val dialog = CustomDialogFrTheme()
            dialog.show(supportFragmentManager,"dialog_theme")
        })

    }
}