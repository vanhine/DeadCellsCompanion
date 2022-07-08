package com.mrwinston.deadcellsref.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrwinston.deadcellsref.R
import com.mrwinston.deadcellsref.util.GridItemOffsetDecoration
import com.mrwinston.deadcellsref.util.adapters.GearItemAdapter
import com.mrwinston.deadcellsref.view.MainActivity
import com.mrwinston.deadcellsref.viewmodel.GearViewModel
import kotlinx.android.synthetic.main.grenades_fragment.*
import javax.inject.Inject

/* Fragment which displays all Grenades in a grid. */
class GrenadesFragment : Fragment(R.layout.grenades_fragment) {
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

        return super.onCreateView(
            inflater,
            container,
            savedInstanceState
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = grenades_recycler
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
            fragmentTransaction.replace(
                R.id.main_view_frame,
                GearInfoFragment(
                    gearItem
                )
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        gearViewModel.grenades.observe(viewLifecycleOwner, Observer { grenades ->
            gearItemAdapter.gearList = grenades
            gearItemAdapter.notifyDataSetChanged()
        })
    }
}
