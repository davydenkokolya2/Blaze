package com.example.blaze.ui.football_completed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.blaze.databinding.FragmentFootballCompletedBinding
import com.example.blaze.ui.host.HostViewModel
import com.example.blaze.util.Host

class FootballCompletedFragment : Fragment() {


    private lateinit var binding: FragmentFootballCompletedBinding
    private val hostViewModel: HostViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFootballCompletedBinding.inflate(inflater, container, false)
        binding.btnPetersb.setOnClickListener {
            hostViewModel.loadState(Host.COMPLETED_TEAM)
        }
        return binding.root
    }

}