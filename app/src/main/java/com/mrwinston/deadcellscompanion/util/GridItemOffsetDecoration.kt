package com.mrwinston.deadcellscompanion.util

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

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