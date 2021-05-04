package com.example.epass.presentation.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.epass.R
import com.example.epass.databinding.FragmentButtomDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class BottomSheetDialog : BottomSheetDialogFragment(){
    // private val - you can't access this property from the outside of this class
    private lateinit var binding: FragmentButtomDialogBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.fragment_buttom_dialog,
                container,
                false)
        // TODO : has to be fixed

        binding.turnYourPhone.setOnClickListener(View.OnClickListener {

        })

        binding.ivReady.setOnClickListener( View.OnClickListener {
            binding.ivReady.setImageDrawable(ContextCompat.getDrawable(activity?.applicationContext!!,R.drawable.ic_success))
            binding.turnYourPhone.text = "Сканирование прошло успешно"
            binding.tvReady.text = ""
           //dismiss()


        })

        return binding.root
    }



}