package com.donghwan.recycler_diff.model

import android.graphics.Color

data class Tile(
    val number: Int,
    val color: Int =
        if (number < 100) Color.BLACK + (256 * 256 * 256 * number * (100 - number) / 25) / (100)
        else Color.WHITE
) {
    override fun equals(other: Any?): Boolean {
        return (other as? Tile)?.let {
            it.number == this.number
        } ?: super.equals(other)
    }
}