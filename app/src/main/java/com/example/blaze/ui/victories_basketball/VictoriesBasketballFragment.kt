package com.example.blaze.ui.victories_basketball

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.blaze.databinding.FragmentVictoriesBasketballBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Screens

class VictoriesBasketballFragment : Fragment() {

    private val screensViewModel: ScreensViewModel by activityViewModels()
    private lateinit var binding: FragmentVictoriesBasketballBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVictoriesBasketballBinding.inflate(inflater, container, false)
        binding.btnBackVictoriesBasketball.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }
        return binding.root
    }
}