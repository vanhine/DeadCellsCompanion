package com.mrwinston.deadcellscompanion.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrwinston.deadcellscompanion.R
import com.mrwinston.deadcellscompanion.adapters.GearItemAdapter
import com.mrwinston.deadcellscompanion.util.GridItemOffsetDecoration
import com.mrwinston.deadcellscompanion.viewmodel.GearViewModel
import kotlinx.android.synthetic.main.powers_fragment.*

class PowersFragment : Fragment(R.layout.powers_fragment) {
    private val gearViewModel = GearViewModel()
    private lateinit var recyclerView: RecyclerView
    private val gearItemAdapter = GearItemAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = power_recycler
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        val gridItemOffsetDecoration =
            GridItemOffsetDecoration(
                requireContext(),
                R.dimen.grid_item_offset
            )
        recyclerView.addItemDecoration(gridItemOffsetDecoration)
        recyclerView.adapter = gearItemAdapter
        gearItemAdapter.onItemClick = { gearItem ->
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_view_frame, GearInfoFragment(gearItem))
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        gearViewModel.powers.observe(viewLifecycleOwner, Observer { powers ->
            gearItemAdapter.gearList = powers
            gearItemAdapter.notifyDataSetChanged()
        })
    }
}
