package com.example.blaze.ui.victories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.blaze.databinding.FragmentVictoriesBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Screens

class VictoriesFragment : Fragment() {

    private val screensViewModel: ScreensViewModel by activityViewModels()
    private lateinit var binding: FragmentVictoriesBinding

    private lateinit var viewModel: VictoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVictoriesBinding.inflate(inflater, container, false)
        binding.btnBackVictoriesFootball.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }
        return binding.root
    }
}