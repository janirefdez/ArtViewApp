package com.janirefernandez.artviewapp.domain

import com.janirefernandez.artviewapp.data.MuseumObjectRepository
import javax.inject.Inject


class GetMuseumObjectsUseCase @Inject constructor(
    private val repository: MuseumObjectRepository
) {
    suspend operator fun invoke() = repository.getRecordsObjects(20, "Prints", 1)
}