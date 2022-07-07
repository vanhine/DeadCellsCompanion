package com.mrwinston.deadcellscomp.util.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrwinston.deadcellscomp.R
import com.mrwinston.deadcellscomp.data.model.GearItem
import kotlinx.android.synthetic.main.grid_item_view.view.*

/**
 * Adapter used to display an item in a grid view.
 *
 * An icon will be shown with the items image as well as name.
 */
class GearItemAdapter :
    RecyclerView.Adapter<GearItemAdapter.GearItemViewHolder>() {
    var onItemClick: ((GearItem) -> Unit)? = null
    var gearList = listOf<GearItem>()

    inner class GearItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val gearImage = itemView.item_image
        private val gearName = itemView.item_name

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(gearList[adapterPosition])
            }
        }

        fun bind(gearItem: GearItem) {
            Glide.with(itemView).load(gearItem.imageUrl).into(gearImage)
            gearImage.contentDescription = gearItem.name
            gearName.text = gearItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GearItemViewHolder {
        return GearItemViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.grid_item_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = gearList.size

    override fun onBindViewHolder(holder: GearItemViewHolder, position: Int) {
        holder.bind(gearList[position])
    }
}