package com.example.blaze.ui.host

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blaze.util.Host
import com.example.blaze.util.Sports
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HostViewModel @Inject constructor() : ViewModel() {
    private val _stateHost = MutableStateFlow<Host>(Host.NULL)
    val stateHost: StateFlow<Host> = _stateHost

    fun loadState(host: Host) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHost.emit(host)
        }
    }

    private val _stateSports = MutableStateFlow<Sports>(Sports.FOOTBALL)
    val stateSports: StateFlow<Sports> = _stateSports
    fun loadStateSports(sports: Sports) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateSports.emit(sports)
        }
    }
}