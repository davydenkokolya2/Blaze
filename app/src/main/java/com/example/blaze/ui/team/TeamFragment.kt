package com.example.blaze.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.blaze.databinding.FragmentTeamBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Screens

class TeamFragment : Fragment() {

    private val screensViewModel: ScreensViewModel by activityViewModels()
    private lateinit var binding: FragmentTeamBinding

    private lateinit var viewModel: TeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamBinding.inflate(inflater, container, false)
        binding.btnBackTeams.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }
        return binding.root
    }

}