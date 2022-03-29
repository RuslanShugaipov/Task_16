package com.example.task16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.task16.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(CrimeFragment.newInstance(), R.id.crimeFrameLayout)
    }

    private fun openFrag(f: Fragment, idHolder: Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}