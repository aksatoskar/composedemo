package com.aksatoskar.composedemousers.data.remote.api

import com.aksatoskar.composedemousers.data.remote.model.response.MatchProfileResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/")
    suspend fun getMatchProfiles(@Query("results") results: Int) : Response<MatchProfileResponse>
}