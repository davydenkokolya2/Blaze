package com.example.blaze.ui.league

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.blaze.databinding.FragmentLeagueBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Screens

class LeagueFragment : Fragment() {

    private val screensViewModel: ScreensViewModel by activityViewModels()
    private lateinit var binding: FragmentLeagueBinding

    private lateinit var viewModel: LeagueViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeagueBinding.inflate(inflater, container, false)
        binding.btnBackLeague.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }
        return binding.root
    }
}