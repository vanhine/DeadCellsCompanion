package com.mrwinston.deadcellsref.data.model

data class TrapOrTurret(
    override val name: String,
    override val description: String,
    override val blueprintLocation: String,
    val baseDamage: String,
    val baseCooldownTime: String,
    override val scalingUrl: String,
    override val imageUrl: String
) : GearItem {
    companion object {
        /**
         * Converts a document to a [TrapOrTurret] object
         *
         * @param document is a map containing attributes about a [TrapOrTurret].
         */
        fun documentToTrapOrTurret(document: Map<String, Any>): TrapOrTurret {
            val name = document["name"].toString()
            val description = document["description"].toString()
            val blueprintLocation = document["blueprint_location"].toString()
            val baseDamage = document["base_damage"].toString()
            val baseCooldownTime = document["base_cooldown_time"].toString()
            val scalingUrl = document["scaling"].toString()
            val imageUrl = document["image_url"].toString()
            return TrapOrTurret(
                name,
                description,
                blueprintLocation,
                baseDamage,
                baseCooldownTime,
                scalingUrl,
                imageUrl
            )
        }
    }
}