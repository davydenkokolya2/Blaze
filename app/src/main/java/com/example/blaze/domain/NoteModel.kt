package com.example.blaze.domain

data class NoteModel(
    val title: String,
    val text: String,
    var visible: Boolean,
)
