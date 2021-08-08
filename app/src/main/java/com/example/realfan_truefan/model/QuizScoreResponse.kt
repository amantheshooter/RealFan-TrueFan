package com.example.realfan_truefan.model

import com.google.gson.annotations.SerializedName

data class QuizScoreResponse(@SerializedName("quizFound") val quizFound : Boolean,
                             @SerializedName("rank") val rank : Int,
                             @SerializedName("score") val score : Int,
                             @SerializedName("msg") val msg : String)
