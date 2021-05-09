package com.rightmove.library_property.domain.repo

import com.rightmove.library_property.domain.model.Property
import com.rightmove.library_property.base.Result

internal interface PropertyRepo {
    suspend fun getProperties(): Result<List<Property>>
}