package com.donghwan.recycler_diff.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.donghwan.recycler_diff.model.Event
import com.donghwan.recycler_diff.model.Tile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _items: MutableLiveData<Event<List<Tile>>> = MutableLiveData()
    val items: LiveData<Event<List<Tile>>>
        get() = _items

    private val initItem = IntArray(16) { i -> i + 1 }.map { Tile(number = it) }.toList()

    init {
        reset()
    }

    fun reset() {
        _items.value = Event(initItem.toList())
    }

    fun shuffle() {
        items.value?.peekContent()?.let {
            _items.value = Event(it.shuffled())
        }
    }
}