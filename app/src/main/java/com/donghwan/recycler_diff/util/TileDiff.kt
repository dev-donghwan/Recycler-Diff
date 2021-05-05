package com.donghwan.recycler_diff.util

import androidx.recyclerview.widget.DiffUtil
import com.donghwan.recycler_diff.model.Tile

class TileDiff(
    private val oldItem: List<Tile>,
    private val newItem: List<Tile>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItem.size

    override fun getNewListSize(): Int = newItem.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItem[oldItemPosition].number == newItem[newItemPosition].number
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areItemsTheSame(oldItemPosition, newItemPosition)
    }
}