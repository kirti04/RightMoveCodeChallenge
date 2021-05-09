package com.rightmove.library_property.remote.source.property

import retrofit2.Response
import retrofit2.http.GET

internal interface PropertyService {

    @GET("properties.json")
    suspend fun getProperties() : Response<PropertiesRemote>
}