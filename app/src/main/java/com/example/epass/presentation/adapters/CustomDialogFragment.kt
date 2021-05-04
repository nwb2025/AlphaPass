package com.example.epass.presentation.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.epass.R

class CustomDialogFragment: DialogFragment{

    constructor()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView:View= inflater.inflate(R.layout.dialog_fragment,container,false)

        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }


        var submitButton:Button=rootView.findViewById(R.id.submit_button)
        submitButton.setOnClickListener {
            Toast.makeText(context,"Пропуск удален",Toast.LENGTH_SHORT).show()
            dismiss()
            activity?.finish()
        }

        var cancelButton:Button=rootView.findViewById(R.id.cancel_button)
        cancelButton.setOnClickListener {
            Toast.makeText(context,"Удаление отменено",Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return rootView
    }
}