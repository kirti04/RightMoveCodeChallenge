package com.rightmove.library_property.remote.source.property

import com.rightmove.library_property.base.Result
import com.rightmove.library_property.base.mapSuccess
import com.rightmove.library_property.data.PropertyRemoteDataSource
import com.rightmove.library_property.domain.model.Property
import com.rightmove.library_property.remote.base.BaseRemoteSource
import com.rightmove.library_property.remote.base.ServiceFactory
import javax.inject.Inject

internal class PropertyRemoteDataSourceImpl @Inject constructor(
    private val propertyMapper: PropertyMapper,
    private val serviceFactory: ServiceFactory
) : BaseRemoteSource(), PropertyRemoteDataSource {

    override suspend fun getProperties(): Result<List<Property>> = safeApiCall {
        serviceFactory.makeService(PropertyService::class.java).getProperties()
    }.mapSuccess {
        propertyMapper.map(it.value)
    }
}