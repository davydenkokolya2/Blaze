package com.example.blaze.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.blaze.databinding.FragmentFavouritesBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Favourites
import com.example.blaze.util.Screens
import kotlinx.coroutines.launch

class FavouritesFragment : Fragment() {

    private val screensViewModel: ScreensViewModel by activityViewModels()
    private lateinit var binding: FragmentFavouritesBinding
    private val favouritesViewModel: FavouritesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        binding.btnBackFavourites.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }
        binding.btnCompletedFalseFV.setOnClickListener {
            favouritesViewModel.loadState(Favourites.COMPLETED)
        }
        binding.btnUpcomingFalseFV.setOnClickListener {
            favouritesViewModel.loadState(Favourites.UPCOMING)
        }
        lifecycleScope.launch {
            favouritesViewModel.stateFavourites.collect {
                binding.btnUpcomingFalseFV.visibility = View.INVISIBLE
                binding.btnUpcomingTrueFV.visibility = View.INVISIBLE
                binding.btnCompletedFalseFV.visibility = View.INVISIBLE
                binding.btnCompletedTrueFV.visibility = View.INVISIBLE
                when(it) {
                    Favourites.UPCOMING -> {
                        binding.btnUpcomingTrueFV.visibility = View.VISIBLE
                        binding.btnCompletedFalseFV.visibility = View.VISIBLE
                    }
                    Favourites.COMPLETED -> {
                        binding.btnUpcomingFalseFV.visibility = View.VISIBLE
                        binding.btnCompletedTrueFV.visibility = View.VISIBLE
                    }
                }
            }
        }
        return binding.root
    }
}