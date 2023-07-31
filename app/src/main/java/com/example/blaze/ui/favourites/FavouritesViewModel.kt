package com.example.blaze.ui.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blaze.util.Favourites
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavouritesViewModel : ViewModel() {
    private val _stateFavourites = MutableStateFlow<Favourites>(Favourites.COMPLETED)
    val stateFavourites: StateFlow<Favourites> = _stateFavourites

    fun loadState(favourites: Favourites) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateFavourites.emit(favourites)
        }
    }
}