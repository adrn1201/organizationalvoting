package com.example.organizationalvoting.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.organizationalvoting.util.Helper
import com.google.android.material.snackbar.Snackbar

class ViewModel: ViewModel() {
    private val _president = MutableLiveData<Array<String>>()
    private val _vicePresident = MutableLiveData<Array<String>>()
    private val _secretary = MutableLiveData<Array<String>>()
    private val _treasurer = MutableLiveData<Array<String>>()
    private val _pro = MutableLiveData<Array<String>>()

    val president: LiveData<Array<String>> = _president
    val vicePresident: LiveData<Array<String>> = _vicePresident
    val secretary: LiveData<Array<String>> = _secretary
    val treasurer: LiveData<Array<String>> = _treasurer
    val pro: LiveData<Array<String>> = _pro

    init {
        _president.value = Helper.getPresidentData()
        _vicePresident.value = Helper.getVicePresident()
        _secretary.value = Helper.getSecretary()
        _treasurer.value = Helper.getTreasurer()
        _pro.value = Helper.getPro()
    }

    fun test(value: Any): Boolean{
        if(value.toString() == "Choose a President"){
            return false
        }
        return true
    }
}