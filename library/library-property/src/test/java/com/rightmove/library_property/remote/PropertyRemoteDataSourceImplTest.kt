package com.rightmove.library_property.remote

import com.rightmove.library_property.remote.base.ServiceFactory
import com.rightmove.library_property.remote.source.property.PropertiesRemote
import com.rightmove.library_property.remote.source.property.PropertyMapper
import com.rightmove.library_property.remote.source.property.PropertyRemoteDataSourceImpl
import com.rightmove.library_property.remote.source.property.PropertyService
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

internal class PropertyRemoteDataSourceImplTest {

    companion object {
        private val serviceFactoryMock = mockk<ServiceFactory>()
        private val propertyServiceMock = mockk<PropertyService>()
    }

    private lateinit var sut: PropertyRemoteDataSourceImpl

    @Before
    fun setUp() {
        clearAllMocks()
        setUpPropertyService()
        setUpPropertyServiceMockResponse()
        sut = PropertyRemoteDataSourceImpl(PropertyMapper(), serviceFactoryMock)
    }

    private fun setUpPropertyService() {
        every {
            serviceFactoryMock.makeService(PropertyService::class.java)
        } answers {
            propertyServiceMock
        }
    }

    private fun setUpPropertyServiceMockResponse(
        response: PropertiesRemote = PropertiesRemote(emptyList())
    ) {
        coEvery {
            propertyServiceMock.getProperties()
        } coAnswers {
            Response.success(response)
        }
    }

    @Test
    fun getProperties() {
        runBlocking {
            sut.getProperties()
            coVerify(exactly = 1) { propertyServiceMock.getProperties() }
        }
    }
}