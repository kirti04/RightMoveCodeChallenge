package com.rightmove.library_property.remote.source.property

import com.rightmove.library_property.domain.model.Property
import com.rightmove.library_property.remote.base.Mapper
import javax.inject.Inject

internal class PropertyMapper @Inject constructor() : Mapper<PropertiesRemote, List<Property>> {

    override fun map(input: PropertiesRemote): List<Property> {
        return input.properties.map { makeProperty(it) }
    }

    private fun makeProperty(input: PropertiesRemote.Property): Property {
        return Property(
            bedrooms = input.bedrooms,
            number = input.number,
            address = input.address,
            price = input.price,
            propertyType = input.propertyType,
            postcode = input.postcode,
            id = input.id,
            bathrooms = input.bathrooms,
            region = input.region
        )
    }
}