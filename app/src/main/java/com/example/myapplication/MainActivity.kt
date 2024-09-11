package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val job: Job= Job()
    private val coroutine: CoroutineScope= CoroutineScope(Dispatchers.Default+job)

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val job1= coroutine.launch ( Dispatchers.IO) {
            for (i in 1..10000){
                delay(1000)
                Log.i("Test","$i")
            }
        }
        val job2= coroutine.launch ( Dispatchers.IO) {
            for (i in 1..10000){
                delay(1000)
                Log.i("Test","$i")
            }
        }
        job.cancel()

    }

    fun getString1(): String {
        return "Test1"
    }

    fun getString2(): String {
        return "Test2"
    }
}

