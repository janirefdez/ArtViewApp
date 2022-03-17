package com.janirefernandez.artviewapp.data

import com.janirefernandez.artviewapp.data.model.MuseumObjectProvider
import com.janirefernandez.artviewapp.data.model.Record
import com.janirefernandez.artviewapp.data.network.ApiService
import javax.inject.Inject

class MuseumObjectRepository @Inject constructor(
    private val api: ApiService,
    private val museumObjectProvider: MuseumObjectProvider
) {

    suspend fun getRecordsObjects(size: Int, classification: String, hasImage: Int): List<Record> {
        val response = api.getRecordObjects(size, classification, hasImage)
        museumObjectProvider.museumObjectList = response
        return response
    }
}