package com.mrwinston.deadcellscomp.util

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView Item decoration which sets the margins for an item.
 *
 * This helps center the items properly.
 *
 * @param itemOffset is the size (in dp) to set the margins to.
 */
class GridItemOffsetDecoration(val itemOffset: Int) : RecyclerView.ItemDecoration() {
    constructor(
        context: Context,
        itemOffsetId: Int
    ) : this(context.resources.getDimensionPixelOffset(itemOffsetId))

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(itemOffset, itemOffset, itemOffset, itemOffset)
    }
}