package com.rightmove.library_property.domain.model

data class Property(
    val bedrooms: Int,
    val number: String,
    val address: String,
    val price: Int,
    val propertyType: String,
    val postcode: String,
    val id: Int,
    val bathrooms: Int,
    val region: String
)