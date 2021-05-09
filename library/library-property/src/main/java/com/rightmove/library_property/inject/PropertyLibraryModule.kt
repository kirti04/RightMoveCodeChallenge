package com.rightmove.library_property.inject

import com.rightmove.library_property.data.PropertyRemoteDataSource
import com.rightmove.library_property.data.PropertyRepoImpl
import com.rightmove.library_property.domain.repo.PropertyRepo
import com.rightmove.library_property.remote.source.property.PropertyRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PropertyLibraryModule {

    @Binds
    internal abstract fun bindPropertyRepo(propertyRepo: PropertyRepoImpl): PropertyRepo

    @Binds
    internal abstract fun bindsPropertyRemoteDataSource(
        propertyRemoteDataSource: PropertyRemoteDataSourceImpl
    ): PropertyRemoteDataSource
}