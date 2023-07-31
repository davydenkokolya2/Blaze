package com.example.blaze.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.blaze.databinding.FragmentMenuBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.ui.host.HostViewModel
import com.example.blaze.util.Screens
import com.example.blaze.util.Sports

class MenuFragment : Fragment() {

    private val hostViewModel: HostViewModel by activityViewModels()
    private val screensViewModel: ScreensViewModel by activityViewModels()
    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding.btnCalendar.setOnClickListener {
            screensViewModel.loadState(Screens.CALENDAR)
        }
        binding.btnNotes.setOnClickListener {
            screensViewModel.loadState(Screens.NOTES)
        }
        binding.btnFactor.setOnClickListener {
            screensViewModel.loadState(Screens.FACTOR)
        }
        binding.btnFavourites.setOnClickListener {
            screensViewModel.loadState(Screens.FAVOURITES)
        }
        binding.btnLeague.setOnClickListener {
            screensViewModel.loadState(Screens.LEAGUE)
        }
        binding.btnTeam.setOnClickListener {
            screensViewModel.loadState(Screens.TEAM)
        }
        binding.btnVictories.setOnClickListener {
            when (hostViewModel.stateSports.value) {
                Sports.FOOTBALL -> {
                    screensViewModel.loadState(Screens.VICTORIES_FOOTBALL)
                }
                Sports.BASKETBALL -> {
                    screensViewModel.loadState(Screens.VICTORIES_BASKETBALL)
                }
                else -> {
                    screensViewModel.loadState(Screens.VICTORIES_FOOTBALL)
                }
            }
        }
        return binding.root
    }
}