package com.example.blaze.ui.add_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.blaze.databinding.FragmentAddNoteBinding
import com.example.blaze.domain.NoteModel
import com.example.blaze.ui.ScreensViewModel
import com.example.blaze.util.Constants
import com.example.blaze.util.Screens

class AddNoteFragment : Fragment() {

    private val screensViewModel: ScreensViewModel by activityViewModels()
    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        binding.btnBackCreateNote.setOnClickListener {
            screensViewModel.loadState(Screens.HOST)
        }

        binding.btnCreateNote.setOnClickListener {
            Constants.listNotes.add(
                NoteModel(
                    binding.textInputTitle.text.toString(),
                    binding.textInputNoteText.text.toString(),
                    true
                )
            )
            screensViewModel.loadState(Screens.NOTES)
        }
        return binding.root
    }

}