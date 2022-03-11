package com.janirefernandez.artviewapp.data.network

import com.janirefernandez.artviewapp.core.RetrofitHelper
import com.janirefernandez.artviewapp.core.Constants
import com.janirefernandez.artviewapp.data.model.MuseumObject
import com.janirefernandez.artviewapp.data.model.Record
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getRecordObjects(size: Int, classification: String): List<Record> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getMuseumObjects(Constants.apiKey, size, classification)
            if (response.body() == null) {
                emptyList()
            } else {
                response.body()!!.records
            }

        }
    }
}