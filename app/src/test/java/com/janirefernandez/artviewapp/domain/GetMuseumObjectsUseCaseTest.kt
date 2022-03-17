package com.janirefernandez.artviewapp.domain

import com.janirefernandez.artviewapp.data.MuseumObjectRepository
import com.janirefernandez.artviewapp.kits.KitTests
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetMuseumObjectsUseCaseTest {

    @RelaxedMockK
    private lateinit var museumObjectRepository: MuseumObjectRepository

    lateinit var getMuseumObjectsUseCase: GetMuseumObjectsUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getMuseumObjectsUseCase = GetMuseumObjectsUseCase(museumObjectRepository)
    }


    @Test
    fun getApiResponse() = runBlocking {
        //Given
        val recordList = KitTests.createMockRecordList(1)
        coEvery {
            museumObjectRepository.getRecordsObjects(
                20,
                "Prints",
                1
            )
        } returns recordList
        //When
        val response = getMuseumObjectsUseCase()
        //Then
        coVerify(exactly = 1) { museumObjectRepository.getRecordsObjects(20, "Prints", 1) }
        assert(response == recordList)
    }

}