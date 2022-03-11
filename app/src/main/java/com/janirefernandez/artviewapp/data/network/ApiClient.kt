package com.janirefernandez.artviewapp.data.network

import com.janirefernandez.artviewapp.data.model.MuseumObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/object")
    suspend fun getMuseumObjects(@Query("apikey") apikey: String, @Query("size") size: Int = 5, @Query("classification") classification: String) : Response<MuseumObject>

}