package com.example.realfan_truefan.utils

import com.example.realfan_truefan.api.ApiService

class ApiHelper(private val apiService: ApiService) {
    suspend fun getResponse(url: String) = apiService.getQuizScoreResponse(url)
}