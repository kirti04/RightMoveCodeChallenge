package com.rightmove.codechallenge.main

import com.rightmove.library_property.domain.model.Property

object PropertyStubFactory {

    fun makeProperty(
        bedrooms: Int = 0,
        number: String = "",
        address: String = "",
        price: Int = 0,
        propertyType: String = "",
        postcode: String = "",
        id: Int = 0,
        bathrooms: Int = 0,
        region: String = ""
    ) = Property(bedrooms, number, address, price, propertyType, postcode, id, bathrooms, region)
}