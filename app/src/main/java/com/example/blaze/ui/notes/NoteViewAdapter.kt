package com.example.blaze.ui.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blaze.databinding.ItemNoteBinding
import com.example.blaze.domain.NoteModel
import com.example.blaze.util.Constants

class NoteViewAdapter(data: List<NoteModel>, private val onItemClick: () -> Unit) :
    RecyclerView.Adapter<NoteViewAdapter.IntViewHolder>() {

    var list: List<NoteModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class IntViewHolder(
        val binding: ItemNoteBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(inflater, parent, false)

        return IntViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitle.text = item.title
        holder.binding.tvNoteText.text = item.text
        holder.binding.btnTrash.setOnClickListener {
            Constants.listNotes.removeAt(position)
            onItemClick()
        }


        /*if (!item.visible)
            holder.binding.root.visibility = View.GONE*/
    }
}
