package com.mrwinston.deadcellscompanion.data.model

data class Power(
    override val name: String,
    override val description: String,
    override val blueprintLocation: String,
    val baseDamage: String,
    val baseCooldownTime: String,
    val damageReduction: String,
    override val scalingUrl: String,
    override val imageUrl: String
) : GearItem {
    companion object {
        fun documentToPower(document: Map<String, Any>): Power {
            val name = document["name"].toString()
            val description= document["description"].toString()
            val blueprintLocation = document["blueprint_location"].toString()
            val baseDamage = document["base_damage"].toString()
            val baseCooldownTime = document["base_cooldown_time"].toString()
            val damageReduction = document["damage_reduction"].toString()
            val scalingUrl = document["scaling"].toString()
            val imageUrl = document["image_url"].toString()
            return Power(
                name,
                description,
                blueprintLocation,
                baseDamage,
                baseCooldownTime,
                damageReduction,
                scalingUrl,
                imageUrl)
        }
    }
}