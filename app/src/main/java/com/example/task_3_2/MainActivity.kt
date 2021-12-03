package com.example.task_3_2

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCheckAnswer = findViewById<Button>(R.id.btnCheckAnswer)
        val userInput = findViewById<TextInputLayout>(R.id.userInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val countToTry = findViewById<TextView>(R.id.countToTry)

        var randomNumber = Random.nextInt(0, 1000)
        var tryCount = 12;
        countToTry.text = "You have attempts:" + tryCount.toString()

        val newScreenIntent = Intent(this, ResultActivity::class.java)
        newScreenIntent.putExtra("secretNumber", randomNumber.toString())

        btnCheckAnswer.setOnClickListener {
            if (!userInput.editText?.text?.toString().isNullOrEmpty() && userInput.editText?.text?.toString()?.isDigitsOnly() == true){
                tryCount--
                countToTry.text = "You have attempts:" + tryCount.toString()
                if (randomNumber != userInput.editText?.text?.toString()?.toInt() && tryCount > 0){
                    if (randomNumber > userInput.editText?.text?.toString()?.toInt()!!){
                        resultText.text = getString(R.string.wrongIsBigger)
                        resultText.setTextColor(Color.RED)
                    } else {
                        resultText.text = getString(R.string.wrongIsSmaller)
                        resultText.setTextColor(Color.RED)
                    }
                }
                else if(randomNumber != userInput.editText?.text?.toString()?.toInt() && tryCount <= 0){
                    newScreenIntent.putExtra("isWin", false)
                    startActivity(newScreenIntent)
                } else {
                    newScreenIntent.putExtra("isWin", true)
                    startActivity(newScreenIntent)
                }
            }
            else resultText.text = getString(R.string.plsEnterANum)

        }
    }
}