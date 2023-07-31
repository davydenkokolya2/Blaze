package com.example.blaze.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.blaze.databinding.FragmentCalendarBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Screens

class CalendarFragment : Fragment() {

    private val screensViewModel: ScreensViewModel by activityViewModels()
    private lateinit var binding: FragmentCalendarBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.btnBackCalendar.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }
        return binding.root
    }


}