package com.example.blaze.ui.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blaze.databinding.FragmentNotesBinding
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Constants
import com.example.blaze.util.Screens
import kotlinx.coroutines.launch

class NotesFragment : Fragment() {

    private val screensViewModel: ScreensViewModel by activityViewModels()
    private val notesViewModel: NotesViewModel by activityViewModels()
    private lateinit var binding: FragmentNotesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        binding.btnAddNote.setOnClickListener {
            screensViewModel.loadState(Screens.ADD_NOTE)
        }
        binding.btnBackNote.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvNotes.layoutManager = layoutManager
        lifecycleScope.launch {
            notesViewModel.stateNote.collect {

                binding.rvNotes.adapter = NoteViewAdapter(Constants.listNotes, ::onItemClick)
            }
        }

        binding.rvNotes.adapter = NoteViewAdapter(Constants.listNotes, ::onItemClick)
        return binding.root
    }
    private fun onItemClick() {
        Log.d("test", "dfgfdlpp")
        notesViewModel.loadState(notesViewModel.stateNote.value + 1)
    }

}