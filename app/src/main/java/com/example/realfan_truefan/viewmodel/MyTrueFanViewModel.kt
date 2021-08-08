package com.example.realfan_truefan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.realfan_truefan.utils.NetworkResponse
import com.example.realfan_truefan.utils.Constants.Status
import com.example.realfan_truefan.model.QuizScoreResponse
import com.example.realfan_truefan.utils.Constants.ApiConfig
import com.example.realfan_truefan.utils.ApiHelper
import com.example.realfan_truefan.utils.NetworkResponseEnc
import com.example.realfan_truefan.utils.NetworkUtil
import kotlinx.coroutines.*

class MyTrueFanViewModel : ViewModel() {
    private var networkResponse: NetworkResponse
    val errorMessage = MutableLiveData<String>()
    val quizList = MutableLiveData<QuizScoreResponse>()
    private var job: Job? = null

    init {
        val apiHelper = ApiHelper(NetworkUtil.apiService)
        networkResponse = NetworkResponseEnc(apiHelper)
    }

    /**
     * Method to fetch quiz score from the Mock server by calling REST API for that
     */
    fun getQuizScore() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            Status.LOADING
            val res = networkResponse.getQuizScoreResponse(ApiConfig.SAMPLE_QUIZ_ENDPOINT)
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    quizList.postValue(res.body())
                } else {
                    onError("Error : ${res.message()} ")
                }
            }
        }
    }

    private fun onError(error: String) {
        errorMessage.postValue(error)
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}