package com.example.universityfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.universityfinder.model.University

class UniversityAdapter(
    private val universities: List<University>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>() {

    inner class UniversityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.universityName)

        fun bind(university: University) {
            nameTextView.text = university.name
            itemView.setOnClickListener {
                val url = university.web_pages.getOrNull(0)
                if (url != null) onItemClick(url)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_university, parent, false)
        return UniversityViewHolder(view)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        holder.bind(universities[position])
    }

    override fun getItemCount(): Int = universities.size
}
