package com.example.blaze.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blaze.util.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreensViewModel @Inject constructor() : ViewModel(){
    private val _stateScreens = MutableStateFlow<Screens>(Screens.HOST)
    val stateScreens: StateFlow<Screens> = _stateScreens

    fun loadState(screens: Screens) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateScreens.emit(screens)
        }
    }
}