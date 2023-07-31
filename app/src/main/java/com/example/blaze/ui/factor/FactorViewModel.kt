package com.example.blaze.ui.factor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blaze.util.Factor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FactorViewModel : ViewModel() {
    private val _stateFactor = MutableStateFlow<Factor>(Factor.CLOSE)
    val stateFactor: StateFlow<Factor> = _stateFactor

    fun loadState(factor: Factor) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateFactor.emit(factor)
        }
    }
}