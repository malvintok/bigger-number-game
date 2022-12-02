package com.malvintok.biggernumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.malvintok.biggernumber.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        assignNumbersToButtons()

        binding.btnLeft.setOnClickListener {
            checkAnswer(true)
        }

        binding.btnRight.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNum = binding.btnLeft.text.toString().toInt()
        val rightNum = binding.btnRight.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum

        if(isAnswerCorrect) {
            // Correct answer!!
            binding.backgroundView.setBackgroundColor(Color.GREEN)
            // Show a toast
            Toast.makeText(this,"Correct!", Toast.LENGTH_SHORT).show()
        } else {
            // Wrong answer!
            binding.backgroundView.setBackgroundColor(Color.RED)
            // Show a toast
            Toast.makeText(this,"Wrong!", Toast.LENGTH_SHORT).show()
        }

        assignNumbersToButtons()
    }

    private fun assignNumbersToButtons() {
        val random = Random()
        val leftNum = random.nextInt(10)
        var rightNum = leftNum
        while (rightNum == leftNum) {
            rightNum = random.nextInt(10)
        }
        binding.btnLeft.text = leftNum.toString()
        binding.btnRight.text = rightNum.toString()
    }
}