package com.mrwinston.deadcellscompanion.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.mrwinston.deadcellscompanion.R
import com.mrwinston.deadcellscompanion.data.model.GearItem
import com.mrwinston.deadcellscompanion.view.MainActivity
import com.mrwinston.deadcellscompanion.viewmodel.GearViewModel
import com.mrwinston.deadcellscompanion.viewmodel.GearViewModelFactory
import kotlinx.android.synthetic.main.gear_info_fragment.view.*
import javax.inject.Inject

/**
 * The Fragment which displays an individual piece of gear.
 *
 * Lays out all the information related to a specific type of item.
 *
 * @param gearItem is the item to be displayed
 */
class GearInfoFragment : Fragment(R.layout.gear_info_fragment) {
    @Inject
    lateinit var gearViewModelFactory: GearViewModelFactory
    private lateinit var gearViewModel: GearViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).appComponent.inject(this)
        gearViewModel = gearViewModelFactory.create(GearViewModel::class.java)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gearViewModel.selected.observe(viewLifecycleOwner, Observer<GearItem> { gearItem ->
            view.item_name.text = gearItem.name
            view.description.text = gearItem.description
            view.blueprint_location.text = gearItem.blueprintLocation
            Glide.with(view).load(gearItem.imageUrl).into(view.image)
            Glide.with(view).load(gearItem.scalingUrl).into(view.scaling_image)
        })
//        when (gearItem) {
//            is MeleeWeapon -> {
//                view.apply {
//                    gearItem as MeleeWeapon
//                    extra_info_1_label.text = context.getString(R.string.base_dps)
//                    extra_info_1.text = gearItem.baseDps
//                    extra_info_2_label.text = context.getString(R.string.base_special_dps)
//                    extra_info_2.text = gearItem.baseSpecialDps
//                    extra_info_3_label.visibility = View.GONE
//                    extra_info_3.visibility = View.GONE
//                }
//            }
//            is RangedWeapon -> {
//                view.apply {
//                    extra_info_1_label.text = context.getString(R.string.base_dps)
//                    extra_info_1.text = gearItem.baseDps
//                    extra_info_2_label.text = context.getString(R.string.base_special_dps)
//                    extra_info_2.text = gearItem.baseSpecialDps
//                    extra_info_3_label.visibility = View.GONE
//                    extra_info_3.visibility = View.GONE
//                }
//            }
//            is Shield -> {
//                view.apply {
//                    extra_info_1_label.text = context.getString(R.string.block_damage)
//                    extra_info_1.text = gearItem.blockDamage
//                    extra_info_2_label.text = context.getString(R.string.perry_damage)
//                    extra_info_2.text = gearItem.parryDamage
//                    extra_info_3_label.text = context.getString(R.string.absorb_damage)
//                    extra_info_3.text = gearItem.absorbDamage
//                }
//            }
//            is Grenade -> {
//                view.apply {
//                    extra_info_1_label.text = context.getString(R.string.base_damage)
//                    extra_info_1.text = gearItem.baseDamage
//                    extra_info_2_label.text = context.getString(R.string.base_cooldown_time)
//                    extra_info_2.text = gearItem.baseCooldownTime
//                    extra_info_3_label.text = context.getString(R.string.damage_reduction)
//                    extra_info_3.text = gearItem.damageReduction
//                }
//            }
//            is TrapOrTurret -> {
//                view.apply {
//                    extra_info_1_label.text = context.getString(R.string.base_damage)
//                    extra_info_1.text = gearItem.baseDamage
//                    extra_info_2_label.text = context.getString(R.string.base_cooldown_time)
//                    extra_info_2.text = gearItem.baseCooldownTime
//                    extra_info_3_label.visibility = View.GONE
//                    extra_info_3.visibility = View.GONE
//                }
//            }
//            is Power -> {
//                view.apply {
//                    extra_info_1_label.text = context.getString(R.string.base_damage)
//                    extra_info_1.text = gearItem.baseDamage
//                    extra_info_2_label.text = context.getString(R.string.base_cooldown_time)
//                    extra_info_2.text = gearItem.baseCooldownTime
//                    extra_info_3_label.text = context.getString(R.string.damage_reduction)
//                    extra_info_3.text = gearItem.damageReduction
//                }
//            }
//        }
    }
}