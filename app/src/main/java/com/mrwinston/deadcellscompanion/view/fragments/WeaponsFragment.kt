package com.mrwinston.deadcellscompanion.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.mrwinston.deadcellscompanion.R
import kotlinx.android.synthetic.main.weapon_list_fragment.*

class WeaponsFragment : Fragment(R.layout.weapon_list_fragment) {
    private lateinit var weaponsFragmentAdapter: WeaponsFragmentAdapter
    private lateinit var viewPager: ViewPager2

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
            return when(position) {
                0 -> MeleeWeaponsFragment()
                else -> RangedWeaponsFragment()
            }
        }

    }

    companion object {
        private val TAG = "WeaponsFragment"
    }
}