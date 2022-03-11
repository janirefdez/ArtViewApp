package com.janirefernandez.artviewapp.domain

import com.janirefernandez.artviewapp.data.MuseumObjectRepository

class GetMuseumObjectsUseCase {

    private val repository = MuseumObjectRepository()

    suspend operator fun invoke() = repository.getRecordsObjects(20, "Prints")

}