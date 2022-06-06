package com.mrwinston.deadcellscompanion.data.model

data class Grenade(
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
        /**
         * Converts a document to a [Grenade] object.
         *
         * @param document is a map containing attributes about a [Grenade].
         */
        fun documentToGrenade(document: Map<String, Any>): Grenade {
            val name = document["name"].toString()
            val description = document["description"].toString()
            val blueprintLocation = document["blueprint_location"].toString()
            val baseDamage = document["base_damage"].toString()
            val baseCooldownTime = document["base_cooldown_time"].toString()
            val damageReduction = document["damage_reduction"].toString()
            val scalingUrl = document["scaling"].toString()
            val imageUrl = document["image_url"].toString()
            return Grenade(
                name,
                description,
                blueprintLocation,
                baseDamage,
                baseCooldownTime,
                damageReduction,
                scalingUrl,
                imageUrl
            )
        }
    }
}