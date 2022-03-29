package com.example.task16

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class CrimeDetailViewModel : ViewModel() {
    val crime: MutableLiveData<Crime> by lazy{
        MutableLiveData<Crime>()
    }
}