package com.example.blaze

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.blaze.databinding.FragmentFootballCompletedTeamDetailsOpenBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Screens

class FootballCompletedTeamDetailsOpenFragment : Fragment() {

    private lateinit var binding: FragmentFootballCompletedTeamDetailsOpenBinding
    private val screensViewModel: ScreensViewModel by activityViewModels()

    private lateinit var viewModel: FootballCompletedTeamDetailsOpenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFootballCompletedTeamDetailsOpenBinding.inflate(inflater, container, false)
        binding.btnStatisticMatch.setOnClickListener {
            screensViewModel.loadState(Screens.STATS_FOOTBALL)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(FootballCompletedTeamDetailsOpenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}