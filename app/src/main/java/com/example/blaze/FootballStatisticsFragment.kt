package com.example.blaze

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.blaze.databinding.FragmentFootballStatisticsBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Screens

class FootballStatisticsFragment : Fragment() {

    private lateinit var binding: FragmentFootballStatisticsBinding
    private lateinit var viewModel: FootballStatisticsViewModel
    private val screensViewModel: ScreensViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFootballStatisticsBinding.inflate(inflater, container, false)
        binding.btnBackStatistics.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FootballStatisticsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}