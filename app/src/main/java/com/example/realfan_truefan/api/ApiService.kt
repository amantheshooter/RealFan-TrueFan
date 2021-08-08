package com.example.realfan_truefan.api

import com.example.realfan_truefan.model.QuizScoreResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Interface used by Retrofit for network requests, this interface provides
 * Endpoints and its resultant expected Response
 */

interface ApiService {
    @GET
    suspend fun getQuizScoreResponse(@Url url: String): Response<QuizScoreResponse>
}