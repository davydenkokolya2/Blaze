package com.example.blaze.ui.football_upcoming

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.blaze.R

class FootballUpcomingFragment : Fragment() {

    companion object {
        fun newInstance() = FootballUpcomingFragment()
    }

    private lateinit var viewModel: FootballUpcomingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_football_upcoming, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FootballUpcomingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}