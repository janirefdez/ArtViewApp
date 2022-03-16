package com.janirefernandez.artviewapp.data

import com.janirefernandez.artviewapp.data.model.MuseumObjectProvider
import com.janirefernandez.artviewapp.data.model.Record
import com.janirefernandez.artviewapp.data.network.ApiService

class MuseumObjectRepository {

    private val api = ApiService()

    suspend fun getRecordsObjects(size: Int, classification: String, hasImage: Int): List<Record> {
        val response = api.getRecordObjects(size, classification, hasImage)
        MuseumObjectProvider.museumObjectList = response
        return response
    }
}