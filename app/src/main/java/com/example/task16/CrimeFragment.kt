package com.example.task16

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.task16.databinding.FragmentCrimeBinding
import java.text.SimpleDateFormat
import java.util.Date

class CrimeFragment : Fragment() {
    private lateinit var binding: FragmentCrimeBinding
    private val crimeModel: CrimeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val crime = Crime("Death on the nile", 0, Date(1968, 8, 13, 18, 56 ), true)

        crimeModel.crime.value = crime

        crimeModel.crime.observe(this.viewLifecycleOwner, {
            binding.tvTitle.text = it.title
            binding.tvDate.text = "${crime.date.date}.${crime.date.month}.${crime.date.year} at" +
                    " ${crime.date.hours}:${crime.date.minutes}"
            binding.cbIsSolved.isChecked = it.isSolved
        })

        binding.btnChangeDate.setOnClickListener{
            val dialog = DatePickerFragment(crime.date)
            dialog.show(parentFragmentManager, "datePicker")
            setFragmentResultListener("requestKey"){_, bundle ->
                var year = bundle.getString("year")
                if(year.isNullOrEmpty())
                    year = crime.date.year.toString()
                binding.tvDate.text = "${crime.date.date}.${crime.date.month}.$year at" +
                        " ${crime.date.hours}:${crime.date.minutes}"
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CrimeFragment()
    }
}