package com.rightmove.library_property.data

import com.rightmove.library_property.domain.model.Property
import com.rightmove.library_property.base.Result

internal interface PropertyRemoteDataSource {
    suspend fun getProperties(): Result<List<Property>>
}