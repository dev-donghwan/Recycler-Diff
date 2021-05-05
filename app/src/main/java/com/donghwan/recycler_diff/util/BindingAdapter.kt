package com.donghwan.recycler_diff.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.donghwan.recycler_diff.model.Event
import com.donghwan.recycler_diff.model.Tile
import com.donghwan.recycler_diff.view.MainRecyclerAdapter

@BindingAdapter("binding:setTileItems")
fun RecyclerView.setTileItems(items: Event<List<Tile>>?) {
    items?.peekContent()?.let {
        (this.adapter as? MainRecyclerAdapter)?.setItems(it)
    }
}

@BindingAdapter("binding:setBackGroundColor")
fun View.setBackgroundColor(colorId: Int?) {
    colorId?.let {
        this.setBackgroundColor(colorId)
    }
}