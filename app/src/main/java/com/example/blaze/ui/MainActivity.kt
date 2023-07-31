package com.example.blaze.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.blaze.FootballStatisticsFragment
import com.example.blaze.R
import com.example.blaze.databinding.ActivityMainBinding
import com.example.blaze.ui.add_note.AddNoteFragment
import com.example.blaze.ui.calendar.CalendarFragment
import com.example.blaze.ui.factor.FactorFragment
import com.example.blaze.ui.favourites.FavouritesFragment
import com.example.blaze.ui.host.HostFragment
import com.example.blaze.ui.league.LeagueFragment
import com.example.blaze.ui.notes.NotesFragment
import com.example.blaze.ui.team.TeamFragment
import com.example.blaze.ui.victories.VictoriesFragment
import com.example.blaze.ui.victories_basketball.VictoriesBasketballFragment
import com.example.blaze.util.Screens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val screensViewModel: ScreensViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        lifecycleScope.launch {
            screensViewModel.stateScreens.collect {
                when(it) {
                    Screens.LEAGUE -> replaceFragment(LeagueFragment())
                    Screens.FACTOR -> replaceFragment(FactorFragment())
                    Screens.VICTORIES_FOOTBALL -> replaceFragment(VictoriesFragment())
                    Screens.FAVOURITES -> replaceFragment(FavouritesFragment())
                    Screens.VICTORIES_BASKETBALL -> replaceFragment(VictoriesBasketballFragment())
                    Screens.NOTES -> replaceFragment(NotesFragment())
                    Screens.HOST -> replaceFragment(HostFragment())
                    Screens.CALENDAR -> replaceFragment(CalendarFragment())
                    Screens.ADD_NOTE -> replaceFragment(AddNoteFragment())
                    Screens.TEAM -> replaceFragment(TeamFragment())
                    Screens.STATS_FOOTBALL -> replaceFragment(FootballStatisticsFragment())
                    else -> {}
                }
            }
        }
        //screensViewModel.loadState(Screens.STATS_FOOTBALL)
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}