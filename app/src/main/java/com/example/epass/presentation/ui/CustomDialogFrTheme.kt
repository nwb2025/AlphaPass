package com.example.epass.presentation.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.epass.R
import com.example.epass.databinding.FragmentThemeBinding

class CustomDialogFrTheme : DialogFragment{

    constructor()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentThemeBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_theme , container, false)

        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }

        binding.radioBtnDark.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Dark theme set", Toast.LENGTH_SHORT).show()
            dismiss()
        })
        binding.radioBtnLight.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Light theme set", Toast.LENGTH_SHORT).show()
            dismiss()
        })

        return binding.root
    }

}