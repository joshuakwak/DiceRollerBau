package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.count_up_button)

        rollButton.setOnClickListener {
            rollDice()
        }

        countUpButton.setOnClickListener {
            countUp()
        }
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.textView)
        val randomInt = (1..6).random()
        resultText.text = "$randomInt"
        Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
    }

    /**
     * Added function for Coding Challenge
     */
    private fun countUp(){
        val resultText: TextView = findViewById(R.id.textView)
        var resultValue: Int = resultText.text.toString().getIntValue()

        if(resultValue == 6) {
            return
        }

        resultValue += 1
        resultText.text = resultValue.toString()
    }

    /**
     * EXTENSION FUNCTION
     * Not part of Coding Challenge, but added anyway. :)
     */
    private fun String.getIntValue() : Int {
        return if(this.isDigitsOnly()) this.toInt() else 1
    }
}