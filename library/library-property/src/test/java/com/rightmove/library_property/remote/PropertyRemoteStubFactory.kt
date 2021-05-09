package com.rightmove.library_property.remote

import com.rightmove.library_property.remote.source.property.PropertiesRemote

internal object PropertyRemoteStubFactory {

    fun makePropertyRemote(
        bedrooms: Int = 0,
        number: String = "",
        address: String = "",
        price: Int = 0,
        propertyType: String = "",
        postcode: String = "",
        id: Int = 0,
        bathrooms: Int = 0,
        region: String = ""
    ) = PropertiesRemote.Property(
        bedrooms,
        number,
        address,
        price,
        propertyType,
        postcode,
        id,
        bathrooms,
        region
    )
}