package com.example.blaze.ui.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(): ViewModel() {
    private val _stateNote = MutableStateFlow<Int>(0)
    val stateNote: StateFlow<Int> = _stateNote

    fun loadState(note: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateNote.emit(note)
        }
    }
}