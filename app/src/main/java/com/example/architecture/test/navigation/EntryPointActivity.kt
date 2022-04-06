package com.example.architecture.test.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecture.test.R
import com.example.architecture.test.viewmodel.MovieViewModel

class EntryPointActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}