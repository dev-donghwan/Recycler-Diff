package com.donghwan.recycler_diff.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.donghwan.recycler_diff.R
import com.donghwan.recycler_diff.databinding.ItemTileBinding
import com.donghwan.recycler_diff.model.Tile
import com.donghwan.recycler_diff.util.TileDiff

class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    private val items: ArrayList<Tile> = arrayListOf()

    fun setItems(items: List<Tile>) {
        val diffCallback = TileDiff(oldItem = this.items, newItem = items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_tile,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemTileBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Tile) {
            binding.tileItem = item
            binding.executePendingBindings()
        }
    }
}