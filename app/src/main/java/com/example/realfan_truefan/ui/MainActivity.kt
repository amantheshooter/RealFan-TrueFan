package com.example.realfan_truefan.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.realfan_truefan.R
import com.example.realfan_truefan.viewmodel.MyTrueFanViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var myTrueFanViewModel: MyTrueFanViewModel
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // getting view model
        myTrueFanViewModel = ViewModelProvider(this)[MyTrueFanViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        myTrueFanViewModel.getQuizScore()
        myTrueFanViewModel.quizList.observe(this, {
            score.text = it.score.toString()
            score_msg.text = it.msg.toString()
        })
        myTrueFanViewModel.errorMessage.observe(this, {
            Log.d(TAG, "Error$it")
        })
    }
}