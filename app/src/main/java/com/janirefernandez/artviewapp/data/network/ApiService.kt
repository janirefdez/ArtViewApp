package com.janirefernandez.artviewapp.data.network

import com.janirefernandez.artviewapp.data.model.Record
import com.janirefernandez.artviewapp.di.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(private val api: ApiClient) {

    suspend fun getRecordObjects(size: Int, classification: String, hasImage: Int): List<Record> {
        return withContext(Dispatchers.IO) {
            val response = api.getMuseumObjects(Constants.apiKey, size, classification, hasImage)
            if (response.body() == null) {
                emptyList()
            } else {
                response.body()!!.records
            }

        }
    }
}