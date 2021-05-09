package com.rightmove.codechallenge.main

import com.rightmove.codechallenge.ui.main.MainViewModel
import com.rightmove.library_property.domain.model.Property
import com.rightmove.library_property.domain.usecase.GetPropertiesUseCase
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import com.rightmove.library_property.base.Result
import org.junit.Before
import org.junit.Test
import assertk.assertAll
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
internal class MainViewModelTest : ViewModelTest() {

    companion object {
        private val getPropertiesUseCaseMock = mockk<GetPropertiesUseCase>()
    }

    private val sut = MainViewModel(getPropertiesUseCaseMock)

    private val isLoadingHistory = mutableListOf<Boolean>()

    @Before
    fun setUp() {
        clearAllMocks()
        setUpGetPropertiesUseCaseMock()
        isLoadingObserver()
    }

    private fun isLoadingObserver() {
        sut.isLoading.observeForever {
            isLoadingHistory.add(it)
        }
    }

    private fun setUpGetPropertiesUseCaseMock(
        result: Result<List<Property>> = Result.Success(emptyList())
    ) {
        coEvery {
            getPropertiesUseCaseMock.invoke()
        } coAnswers {
            result
        }
    }

    @Test
    fun onStart_withGetPropertiesUseCaseSuccess() {
        val properties = PropertyStubFactory.run {
            val property1 = makeProperty(price = 200)
            val property2 = makeProperty(price = 400)
            val property3 = makeProperty(price = 600)
            listOf(property1, property2, property3)
        }
        setUpGetPropertiesUseCaseMock(Result.Success(properties))

        sut.onStart()

        assertAll {
            assertThat(isLoadingHistory.size).isEqualTo(2)
            assertThat(isLoadingHistory[0]).isTrue()
            assertThat(isLoadingHistory[1]).isFalse()

            assertThat(sut.averagePrice.value!!).isEqualTo("400.00")
        }
    }

    @Test
    fun onStart_withGetPropertiesUseCaseFailure() {
        setUpGetPropertiesUseCaseMock(Result.Error("Server error"))

        sut.onStart()

        assertAll {
            assertThat(isLoadingHistory.size).isEqualTo(2)
            assertThat(isLoadingHistory[0]).isTrue()
            assertThat(isLoadingHistory[1]).isFalse()

            assertThat(sut.averagePrice.value!!).isEqualTo("Api error")
        }
    }
}