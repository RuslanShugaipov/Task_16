package com.example.task16

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.task16.databinding.FragmentDatePickerBinding
import java.util.*

class DatePickerFragment(date: Date) : DialogFragment() {
    private lateinit var binding: FragmentDatePickerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDatePickerBinding.inflate(inflater, container, false)

        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnSubmit.setOnClickListener {
            setFragmentResult("requestKey", bundleOf(Pair("year", binding.editTextNumber.text.toString())))
            dismiss()
        }

        return binding.root
    }
}