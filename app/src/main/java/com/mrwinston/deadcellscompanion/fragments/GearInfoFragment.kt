package com.mrwinston.deadcellscompanion.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mrwinston.deadcellscompanion.R
import com.mrwinston.deadcellscompanion.models.*
import kotlinx.android.synthetic.main.gear_info_fragment.view.*

class GearInfoFragment(val gearItem: GearItem) : Fragment(R.layout.gear_info_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.item_name.text = gearItem.name
        view.description.text = gearItem.description
        view.blueprint_location.text = gearItem.blueprintLocation
        Glide.with(view).load(gearItem.imageUrl).into(view.image)
        when(gearItem.scalingUrl) {
            BRUT_URL -> view.image.background = ContextCompat.getDrawable(requireContext(), R.drawable.brut_image_background)
            BRUT_TACT_URL -> view.image.background = ContextCompat.getDrawable(requireContext(), R.drawable.brut_tact_image_background)
            BRUT_SURV_URL -> view.image.background = ContextCompat.getDrawable(requireContext(), R.drawable.brut_surv_image_background)
            TACT_URL -> view.image.background = ContextCompat.getDrawable(requireContext(), R.drawable.tact_image_background)
            SURV_URL -> view.image.background = ContextCompat.getDrawable(requireContext(), R.drawable.surv_image_background)
            TACT__SURV_URL -> view.image.background = ContextCompat.getDrawable(requireContext(), R.drawable.tact_surv_image_background)
        }
        Log.d("GEARINFO", gearItem.scalingUrl)
        when(gearItem) {
            is MeleeWeapon -> {
                view.apply {
                    extra_info_1_label.text = "Base DPS"
                    extra_info_1.text = gearItem.baseDps
                    extra_info_2_label.text = "Base Special DPS"
                    extra_info_2.text = gearItem.baseSpecialDps
                    extra_info_3_label.visibility = View.GONE
                    extra_info_3.visibility = View.GONE
                }
            }
            is RangedWeapon -> {
                view.apply {
                    extra_info_1_label.text = "Base DPS"
                    extra_info_1.text = gearItem.baseDps
                    extra_info_2_label.text = "Base Special DPS"
                    extra_info_2.text = gearItem.baseSpecialDps
                    extra_info_3_label.visibility = View.GONE
                    extra_info_3.visibility = View.GONE
                }
            }
            is Shield -> {
                view.apply {
                    extra_info_1_label.text = "Block Damage"
                    extra_info_1.text = gearItem.blockDamage
                    extra_info_2_label.text = "Parry Damage"
                    extra_info_2.text = gearItem.parryDamage
                    extra_info_3_label.text = "Absorb Damage"
                    extra_info_3.text = gearItem.absorbDamage
                }
            }
            is Grenade -> {
                view.apply {
                    extra_info_1_label.text = "Base Damage"
                    extra_info_1.text = gearItem.baseDamage
                    extra_info_2_label.text = "Base Cooldown Time"
                    extra_info_2.text = gearItem.baseCooldownTime
                    extra_info_3_label.text = "Damage Reduction"
                    extra_info_3.text = gearItem.damageReduction
                }
            }
            is TrapOrTurret -> {
                view.apply {
                    extra_info_1_label.text = "Base Damage"
                    extra_info_1.text = gearItem.baseDamage
                    extra_info_2_label.text = "Base Cooldown Time"
                    extra_info_2.text = gearItem.baseCooldownTime
                    extra_info_3_label.visibility = View.GONE
                    extra_info_3.visibility = View.GONE
                }
            }
            is Power -> {
                view.apply {
                    extra_info_1_label.text = "Base Damage"
                    extra_info_1.text = gearItem.baseDamage
                    extra_info_2_label.text = "Base Cooldown Time"
                    extra_info_2.text = gearItem.baseCooldownTime
                    extra_info_3_label.text = "Damage Reduction"
                    extra_info_3.text = gearItem.damageReduction
                }
            }
        }
    }

    companion object {
        private const val BRUT_URL = "https://gamepedia.cursecdn.com/deadcells_gamepedia_en/thumb/5/51/Strength_Stat.png/34px-Strength_Stat.png?version=a29deb6da6ec251797819f83c929286e"
        private const val BRUT_TACT_URL = "https://gamepedia.cursecdn.com/deadcells_gamepedia_en/thumb/5/58/Str_Skill.png/34px-Str_Skill.png?version=c989b620d39769a33ebc0ba7a9a61d86"
        private const val BRUT_SURV_URL = "https://gamepedia.cursecdn.com/deadcells_gamepedia_en/thumb/a/aa/Str_Hp.png/34px-Str_Hp.png?version=a9290818b18c76c7892e6033019aac70"
        private const val TACT_URL = "https://gamepedia.cursecdn.com/deadcells_gamepedia_en/thumb/2/27/Skill_Stat.png/34px-Skill_Stat.png?version=e9640dc8f059333044ae4615969637c9"
        private const val TACT__SURV_URL = "https://gamepedia.cursecdn.com/deadcells_gamepedia_en/thumb/0/05/Skill_Hp.png/34px-Skill_Hp.png?version=b9ac8bbbdba6e806bc7afab351ade39b"
        private const val SURV_URL = "https://gamepedia.cursecdn.com/deadcells_gamepedia_en/thumb/9/90/Health_Stat.png/34px-Health_Stat.png?version=ded56e1a5bd0f867ffd36883f541a3bb"
    }
}