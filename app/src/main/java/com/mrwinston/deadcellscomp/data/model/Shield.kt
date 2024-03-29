package com.mrwinston.deadcellscomp.data.model

data class Shield(
    override val name: String,
    override val description: String,
    override val blueprintLocation: String,
    val blockDamage: String,
    val parryDamage: String,
    val absorbDamage: String,
    override val scalingUrl: String,
    override val imageUrl: String
) : GearItem {
    companion object {
        /**
         * Converts a document to a [Shield] object
         *
         * @param document is a map containing attributes about a [Shield].
         */
        fun documentToShield(document: Map<String, Any>): Shield {
            val name = document["name"].toString()
            val description = document["description"].toString()
            val blueprintLocation = document["blueprint_location"].toString()
            val blockDamage = document["block_damage"].toString()
            val parryDamage = document["parry_damage"].toString()
            val absorbDamage = document["absorb_damage"].toString()
            val scalingUrl = document["scaling"].toString()
            val imageUrl = document["image_url"].toString()
            return Shield(
                name,
                description,
                blueprintLocation,
                blockDamage,
                parryDamage,
                absorbDamage,
                scalingUrl,
                imageUrl
            )
        }
    }
}