package com.mrwinston.deadcellscompanion.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrwinston.deadcellscompanion.R
import com.mrwinston.deadcellscompanion.util.GridItemOffsetDecoration
import com.mrwinston.deadcellscompanion.util.adapters.GearItemAdapter
import com.mrwinston.deadcellscompanion.view.MainActivity
import com.mrwinston.deadcellscompanion.viewmodel.GearViewModel
import kotlinx.android.synthetic.main.shields_fragment.*
import javax.inject.Inject

/* Fragment which displays all Shields in a grid. */
class ShieldsFragment : Fragment(R.layout.shields_fragment) {
    @Inject
    lateinit var gearViewModel: GearViewModel

    @Inject
    lateinit var gearItemAdapter: GearItemAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).appComponent.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = shields_recycler
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
            gearViewModel.selectedItem(gearItem)
            fragmentTransaction.replace(
                R.id.main_view_frame,
                GearInfoFragment()
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        gearViewModel.shields.observe(viewLifecycleOwner, Observer { shields ->
            gearItemAdapter.gearList = shields
            gearItemAdapter.notifyDataSetChanged()
        })
    }
}
