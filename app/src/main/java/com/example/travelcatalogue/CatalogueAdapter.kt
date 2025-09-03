package com.example.travelcatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatalogueAdapter(
    private val context: Context,
    private val onItemClick: (CatalogueItem) -> Unit,
) : RecyclerView.Adapter<CatalogueAdapter.ViewHolder>() {

    private var items: List<CatalogueItem> = emptyList()

    fun updateItems(newItems: List<CatalogueItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val location: TextView = view.findViewById(R.id.location)
        val description: TextView = view.findViewById(R.id.description)
        val type: TextView = view.findViewById(R.id.type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_catalogue, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.location.text = item.location
        holder.type.text = item.type

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}
