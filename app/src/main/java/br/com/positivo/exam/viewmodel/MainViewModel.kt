package br.com.positivo.exam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.positivo.bitwise.Bitwise.or
import br.com.positivo.bitwise.Bitwise.xor

class MainViewModel : ViewModel() {

    private val result: MutableLiveData<CharSequence> = MutableLiveData()

    fun getResult(): LiveData<CharSequence> {
        return result
    }

    fun executeOperator(inputOne: String, inputTwo: String, xor: Boolean) {

        when {
            xor -> result.postValue("${xor(inputOne, inputTwo)} (Hexadecimal)")
            else -> result.postValue("${or(inputOne, inputTwo)} (Hexadecimal)")
        }
    }

    fun resetOutput() {
        result.postValue("")
    }
}