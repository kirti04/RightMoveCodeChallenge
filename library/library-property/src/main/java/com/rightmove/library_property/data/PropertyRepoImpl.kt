package com.rightmove.library_property.data

import com.rightmove.library_property.domain.model.Property
import com.rightmove.library_property.domain.repo.PropertyRepo
import com.rightmove.library_property.base.Result
import javax.inject.Inject

internal class PropertyRepoImpl @Inject constructor(
    private val propertyRemoteDataSource: PropertyRemoteDataSource
) : PropertyRepo {

    override suspend fun getProperties(): Result<List<Property>> {
        return propertyRemoteDataSource.getProperties()
    }
}