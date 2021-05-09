package com.rightmove.library_property.remote.source.property

import com.google.gson.annotations.SerializedName

internal data class PropertiesRemote(
    @SerializedName("properties")
    val properties: List<Property>
) {

    data class Property(
        @SerializedName("bedrooms")
        val bedrooms: Int,
        @SerializedName("number")
        val number: String,
        @SerializedName("address")
        val address: String,
        @SerializedName("price")
        val price: Int,
        @SerializedName("propertyType")
        val propertyType: String,
        @SerializedName("postcode")
        val postcode: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("bathrooms")
        val bathrooms: Int,
        @SerializedName("region")
        val region: String
    )
}


