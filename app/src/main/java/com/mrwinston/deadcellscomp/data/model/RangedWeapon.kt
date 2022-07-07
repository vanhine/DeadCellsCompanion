package com.mrwinston.deadcellscomp.data.model

data class RangedWeapon(
    override val name: String,
    override val description: String,
    override val blueprintLocation: String,
    val baseDps: String,
    val baseSpecialDps: String,
    override val scalingUrl: String,
    override val imageUrl: String
) : GearItem {
    companion object {
        /**
         * Converts a document to a [RangedWeapon] object
         *
         * @param document is a map containing attributes about a [RangedWeapon].
         */
        fun documentToRangedWeapon(document: Map<String, Any>): RangedWeapon {
            val name = document["name"].toString()
            val description = document["description"].toString()
            val blueprintLocation = document["blueprint_location"].toString()
            val baseDps = document["base_dps"].toString()
            val baseSpecialDps = document["base_special_dps"].toString()
            val scalingUrl = document["scaling"].toString()
            val imageUrl = document["image_url"].toString()
            return RangedWeapon(
                name,
                description,
                blueprintLocation,
                baseDps,
                baseSpecialDps,
                scalingUrl,
                imageUrl
            )
        }
    }

}