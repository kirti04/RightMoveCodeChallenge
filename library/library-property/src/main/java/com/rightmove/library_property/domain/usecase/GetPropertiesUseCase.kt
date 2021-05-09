package com.rightmove.library_property.domain.usecase

import com.rightmove.library_property.domain.model.Property
import com.rightmove.library_property.domain.repo.PropertyRepo
import com.rightmove.library_property.base.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPropertiesUseCase @Inject internal constructor(
    private val propertyRepo: PropertyRepo
) {

    suspend fun invoke(): Result<List<Property>> = withContext(Dispatchers.IO) {
        propertyRepo.getProperties()
    }
}