package com.albrecht3.bola8magica

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.albrecht3.bola8magica.databinding.DialogPredictionBinding

class Dialog_prediction: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogPredictionBinding.inflate(inflater,container,false)
        return binding.root
    }
}