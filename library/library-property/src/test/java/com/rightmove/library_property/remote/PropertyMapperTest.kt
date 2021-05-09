package com.rightmove.library_property.remote

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.rightmove.library_property.domain.model.Property
import com.rightmove.library_property.remote.source.property.PropertiesRemote
import com.rightmove.library_property.remote.source.property.PropertyMapper
import org.junit.Test

internal class PropertyMapperTest {

    private val sut = PropertyMapper()

    @Test
    fun name() {
        val propertiesRemote = PropertyRemoteStubFactory.run {
            val property = makePropertyRemote(
                bedrooms = 2,
                number = "201",
                address = "test address",
                price = 200,
                propertyType = "test property",
                postcode = "CCC809",
                id = 1,
                bathrooms = 2,
                region = "test region"
            )
            PropertiesRemote(listOf(property))
        }

        val actualResult = sut.map(input = propertiesRemote)

        val expectedResult = listOf(
            Property(
                bedrooms = 2,
                number = "201",
                address = "test address",
                price = 200,
                propertyType = "test property",
                postcode = "CCC809",
                id = 1,
                bathrooms = 2,
                region = "test region"
            )
        )
        assertThat(actualResult).isEqualTo(expectedResult)
    }
}