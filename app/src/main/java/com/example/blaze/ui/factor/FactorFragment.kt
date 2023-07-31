package com.example.blaze.ui.factor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.blaze.databinding.FragmentFactorBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Factor
import com.example.blaze.util.Screens
import kotlinx.coroutines.launch

class FactorFragment : Fragment() {

    private val screensViewModel: ScreensViewModel by activityViewModels()
    private val factorViewModel: FactorViewModel by activityViewModels()
    private lateinit var binding: FragmentFactorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFactorBinding.inflate(inflater, container, false)
        binding.btnBackFactor.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }
        binding.btnCard1Factor.setOnClickListener {
            when (factorViewModel.stateFactor.value) {
                Factor.CLOSE -> factorViewModel.loadState(Factor.OPEN)
                Factor.OPEN -> factorViewModel.loadState(Factor.CLOSE)
            }
        }
        lifecycleScope.launch {
            factorViewModel.stateFactor.collect {
                when (it) {
                    Factor.OPEN -> {
                        binding.ivRedArrow.visibility = View.VISIBLE
                        binding.constraintLayout.visibility = View.VISIBLE
                        binding.ivWhiteArrow.visibility = View.INVISIBLE
                    }
                    Factor.CLOSE -> {
                        binding.ivRedArrow.visibility = View.INVISIBLE
                        binding.constraintLayout.visibility = View.GONE
                        binding.ivWhiteArrow.visibility = View.VISIBLE
                    }
                }
            }
        }
        return binding.root
    }
}