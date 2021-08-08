package com.example.realfan_truefan.utils

import com.example.realfan_truefan.model.QuizScoreResponse
import retrofit2.Response

interface NetworkResponse {
     suspend fun  getQuizScoreResponse(url:String):Response<QuizScoreResponse>
}