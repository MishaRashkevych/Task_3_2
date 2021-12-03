package com.example.task_3_2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnReset = findViewById<Button>(R.id.btnReset)
        val endMessage = findViewById<TextView>(R.id.endMessage)
        val secretNumber = findViewById<TextView>(R.id.secretNumber)

        val result = intent.getStringExtra("secretNumber")
        val isWin = intent.getBooleanExtra("isWin", true)

        if (isWin){
            endMessage.text = getString(R.string.correctAnswer)
            secretNumber.setTextColor(Color.GREEN)
            secretNumber.text = result
        } else{
            endMessage.text = getString(R.string.endMessage)
            secretNumber.setTextColor(Color.RED)
            secretNumber.text = result
        }

        btnReset.setOnClickListener {
            val newScreenIntent = Intent(this, MainActivity::class.java)
            startActivity(newScreenIntent)
        }
    }
}