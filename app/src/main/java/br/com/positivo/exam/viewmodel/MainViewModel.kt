package br.com.positivo.exam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val result: MutableLiveData<CharSequence> = MutableLiveData()

    fun getResult(): LiveData<CharSequence> {
        return result
    }
}