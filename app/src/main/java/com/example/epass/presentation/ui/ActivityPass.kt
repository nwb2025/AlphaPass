package com.example.epass.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.epass.R
import com.example.epass.databinding.ActivePassBinding
import com.example.epass.databinding.ActivityMainBinding

class ActivityPass : AppCompatActivity() {

    private lateinit var binding : ActivePassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivePassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle:Bundle?  = intent.extras

        if(bundle?.containsKey("name") != null )
        {
            binding.passCardTitle.text = bundle?.getString("name")
        }

        binding.btnBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })

        binding.editPassButton.setOnClickListener( View.OnClickListener {
            val intent = Intent(this@ActivityPass, EditActivity::class.java)
            startActivity(intent)
        })

        binding.phoneImage.setOnClickListener(View.OnClickListener {
            binding.phoneImage.setImageDrawable(ContextCompat.getDrawable(this@ActivityPass, R.drawable.ic_success))
            binding.turnYourPhone.text = "Сканирование прошло успешно"
        })



    }
}