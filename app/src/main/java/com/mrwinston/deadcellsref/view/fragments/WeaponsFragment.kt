package com.mrwinston.deadcellsref.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.mrwinston.deadcellsref.R
import com.mrwinston.deadcellsref.view.MainActivity
import kotlinx.android.synthetic.main.weapon_list_fragment.*

/* Fragment which holds both Melee and Ranged weapons and displays them separate tabs. */
class WeaponsFragment : Fragment(R.layout.weapon_list_fragment) {
    // TODO(vanhine): convert this to be injected
    private lateinit var weaponsFragmentAdapter: WeaponsFragmentAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).appComponent.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        weaponsFragmentAdapter =
            WeaponsFragmentAdapter(
                this
            )
        viewPager = weapon_pager
        viewPager.adapter = weaponsFragmentAdapter
        val tabLayout = weapon_tab_layout
        val tabTitles = listOf("Melee", "Ranged")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
            viewPager.setCurrentItem(tab.position, true)
        }.attach()
    }

    private class WeaponsFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount() = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> MeleeWeaponsFragment()
                else -> RangedWeaponsFragment()
            }
        }

    }
}