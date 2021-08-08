package com.example.realfan_truefan.utils

import com.example.realfan_truefan.model.QuizScoreResponse
import retrofit2.Response

class NetworkResponseEnc(private val apiHelper: ApiHelper) : NetworkResponse {
    override suspend fun getQuizScoreResponse(url: String): Response<QuizScoreResponse> {
        return apiHelper.getResponse(url)
    }
}