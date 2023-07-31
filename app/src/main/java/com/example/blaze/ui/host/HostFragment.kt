package com.example.blaze.ui.host

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.blaze.FootballCompletedTeamDetailsOpenFragment
import com.example.blaze.FootballCompletedTeamMatchesFragment
import com.example.blaze.R
import com.example.blaze.databinding.FragmentHostBinding
import com.example.blaze.ui.football_completed.FootballCompletedFragment
import com.example.blaze.ui.football_upcoming.FootballUpcomingFragment
import com.example.blaze.ui.menu.MenuFragment
import com.example.blaze.util.Host
import com.example.blaze.util.Sports
import kotlinx.coroutines.launch

class HostFragment : Fragment() {

    private val hostViewModel: HostViewModel by activityViewModels()
    private lateinit var binding: FragmentHostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHostBinding.inflate(inflater, container, false)
        binding.btnCompletedFalse.setOnClickListener {
            hostViewModel.loadState(Host.COMPLETED)
        }
        binding.btnUpcomingFalse.setOnClickListener {
            hostViewModel.loadState(Host.UPCOMING)
        }
        binding.btnBackHome.setOnClickListener {
            hostViewModel.loadState(Host.NULL)
        }
        binding.btnUpcomingNull.setOnClickListener {
            hostViewModel.loadState(Host.UPCOMING)
        }
        binding.btnCompletedNull.setOnClickListener {
            hostViewModel.loadState(Host.COMPLETED)
        }
        binding.btnBasketball.setOnClickListener {
            hostViewModel.loadStateSports(Sports.BASKETBALL)
        }
        binding.btnFootball.setOnClickListener {
            hostViewModel.loadStateSports(Sports.FOOTBALL)
        }
        binding.btnHockey.setOnClickListener {
            hostViewModel.loadStateSports(Sports.HOCKEY)
        }
        binding.btnVoleyball.setOnClickListener {
            hostViewModel.loadStateSports(Sports.VOLLEYBALL)
        }
        lifecycleScope.launch {
            hostViewModel.stateHost.collect {
                binding.btnCompletedNull.visibility = View.INVISIBLE
                binding.btnUpcomingNull.visibility = View.INVISIBLE
                binding.btnBackHome.visibility = View.GONE
                binding.btnCompletedFalse.visibility = View.INVISIBLE
                binding.btnCompletedTrue.visibility = View.INVISIBLE
                binding.btnUpcomingFalse.visibility = View.INVISIBLE
                binding.btnUpcomingTrue.visibility = View.INVISIBLE
                when(it) {
                    Host.NULL -> {
                        binding.btnCompletedNull.visibility = View.VISIBLE
                        binding.btnUpcomingNull.visibility = View.VISIBLE
                        replaceFragment(MenuFragment())
                    }
                    Host.COMPLETED -> {
                        binding.btnBackHome.visibility = View.VISIBLE
                        binding.btnCompletedTrue.visibility = View.VISIBLE
                        binding.btnUpcomingFalse.visibility = View.VISIBLE
                        replaceFragment(FootballCompletedFragment())
                    }
                    Host.UPCOMING -> {
                        binding.btnBackHome.visibility = View.VISIBLE
                        binding.btnCompletedFalse.visibility = View.VISIBLE
                        binding.btnUpcomingTrue.visibility = View.VISIBLE
                        replaceFragment(FootballUpcomingFragment())
                    }
                    Host.COMPLETED_TEAM -> {
                        replaceFragment(FootballCompletedTeamMatchesFragment())
                        binding.btnBackHome.visibility = View.VISIBLE
                        binding.btnCompletedTrue.visibility = View.VISIBLE
                        binding.btnUpcomingFalse.visibility = View.VISIBLE
                    }
                    Host.COMPLETED_TEAM_DETAIL -> {
                        replaceFragment(FootballCompletedTeamDetailsOpenFragment())
                        binding.btnBackHome.visibility = View.VISIBLE
                        binding.btnCompletedTrue.visibility = View.VISIBLE
                        binding.btnUpcomingFalse.visibility = View.VISIBLE
                    }
                }
            }
        }
        lifecycleScope.launch {
            hostViewModel.stateSports.collect {
                binding.btnBasketball.setColorFilter(Color.argb(255, 255, 255, 255))
                binding.btnFootball.setColorFilter(Color.argb(255, 255, 255, 255))
                binding.btnHockey.setColorFilter(Color.argb(255, 255, 255, 255))
                binding.btnVoleyball.setColorFilter(Color.argb(255, 255, 255, 255))
                when(it) {
                    Sports.FOOTBALL -> binding.btnFootball.setColorFilter(Color.argb(255, 255, 0, 0))
                    Sports.HOCKEY -> binding.btnHockey.setColorFilter(Color.argb(255, 255, 0, 0))
                    Sports.VOLLEYBALL -> binding.btnVoleyball.setColorFilter(Color.argb(255, 255, 0, 0))
                    Sports.BASKETBALL -> binding.btnBasketball.setColorFilter(Color.argb(255, 255, 0, 0))
                }
            }
        }
        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()
    }
}