package com.janirefernandez.artviewapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.janirefernandez.artviewapp.domain.GetMuseumObjectsUseCase
import com.janirefernandez.artviewapp.kits.KitTests
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArtViewModelTest {

    @RelaxedMockK
    private lateinit var getMuseumObjectsUseCase: GetMuseumObjectsUseCase

    private lateinit var artViewModel: ArtViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        artViewModel = ArtViewModel(getMuseumObjectsUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created, artModelList should have museum records`() =
        runTest {
            //Given
            val recordList = KitTests.createMockRecordList(2)
            coEvery { getMuseumObjectsUseCase() } returns recordList
            //When
            artViewModel.onCreate()
            //Then
            assert(artViewModel.artModelList.value == recordList)
        }

    @Test
    fun `when viewModel created for the first time and getMuseumObjectsUseCase returns emptyList, artModelList should be null`() =
        runTest {
            //Given
            coEvery { getMuseumObjectsUseCase() } returns emptyList()
            //When
            artViewModel.onCreate()
            //Then
            assert(artViewModel.artModelList.value == null)
        }

    @Test
    fun `when viewModel created for second time and getMuseumObjectsUseCase returns emptyList, artModelList should keep last value`() =
        runTest {
            //Given
            val recordList = KitTests.createMockRecordList(2)
            artViewModel.artModelList.value = recordList.toMutableList()
            coEvery { getMuseumObjectsUseCase() } returns emptyList()
            //When
            artViewModel.onCreate()
            //Then
            assert(artViewModel.artModelList.value == recordList.toMutableList())
        }

    @Test
    fun `when viewmodel is created, isLoading should be false`() =
        runTest {
            //Given
            val recordList = KitTests.createMockRecordList(2)
            coEvery { getMuseumObjectsUseCase() } returns recordList
            //When
            artViewModel.onCreate()
            //Then
            assert(artViewModel.isLoading.value == false)
        }

    @Test
    fun `when viewModel created for the first time and getMuseumObjectsUseCase returns emptyList, isLoading should be true`() =
        runTest {
            //Given
            coEvery { getMuseumObjectsUseCase() } returns emptyList()
            //When
            artViewModel.onCreate()
            //Then
            assert(artViewModel.isLoading.value == true)
        }

    @Test
    fun `when viewModel created for second time and getMuseumObjectsUseCase returns emptyList, isLoading should be true`() =
        runTest {
            //Given
            val recordList = KitTests.createMockRecordList(2)
            artViewModel.artModelList.value = recordList.toMutableList()
            coEvery { getMuseumObjectsUseCase() } returns emptyList()
            //When
            artViewModel.onCreate()
            //Then
            assert(artViewModel.isLoading.value == true)
        }
}