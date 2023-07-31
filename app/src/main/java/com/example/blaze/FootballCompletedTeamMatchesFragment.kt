package com.example.blaze

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.blaze.databinding.FragmentFootballCompletedTeamMatchesBinding
import com.example.blaze.ui.host.HostViewModel
import com.example.blaze.util.Host

class FootballCompletedTeamMatchesFragment : Fragment() {


    private lateinit var binding: FragmentFootballCompletedTeamMatchesBinding
    private val hostViewModel: HostViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFootballCompletedTeamMatchesBinding.inflate(inflater, container, false)
        binding.btnCard1Deatail.setOnClickListener {
            hostViewModel.loadState(Host.COMPLETED_TEAM_DETAIL)
        }
        return binding.root
    }

}