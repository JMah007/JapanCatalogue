package com.example.travelcatalogue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatalogueAdapter(
    private val items: List<CatalogueItems>
) : RecyclerView.Adapter<CatalogueAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val category: TextView = view.findViewById(R.id.category)
        val content: TextView = view.findViewById(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_catalogue, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.category.text = item.location
        holder.content.text = item.description
        holder.content.text = item.type
    }

    override fun getItemCount(): Int = items.size
}
