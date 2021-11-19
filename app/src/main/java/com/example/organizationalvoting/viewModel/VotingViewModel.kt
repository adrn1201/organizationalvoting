package com.example.organizationalvoting.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.organizationalvoting.util.VotingHelper

class VotingViewModel: ViewModel() {
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
        _president.value = VotingHelper.getPresidentData()
        _vicePresident.value = VotingHelper.getVicePresident()
        _secretary.value = VotingHelper.getSecretary()
        _treasurer.value = VotingHelper.getTreasurer()
        _pro.value = VotingHelper.getPro()
    }

    fun validateSelectedItem(presValue: Any, vpValue:Any, secretaryValue: Any, treasurerValue: Any, proValue:Any): Boolean{
        if(presValue.toString() == _president.value?.get(0) || vpValue.toString() == _vicePresident.value?.get(0)
            || secretaryValue.toString() == _secretary.value?.get(0) || treasurerValue.toString() == _treasurer.value?.get(0)
            || proValue.toString() == _pro.value?.get(0)){

            return false
        }
        return true
    }

}