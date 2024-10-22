package com.example.labguide6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.labguide6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intentSecond = intent;

        val b = intentSecond.extras;

        val num1 = b!!.getInt("num1");
        val num2 = b.getInt("num2")
        val num3 = b.getInt("num3")
        val str1 = b.getString("str1")
        val str2 = b.getString("str2")
        val resultingAvg = ((num1 + num2 + num3) / 3).toDouble()
        val resultStr = "$str1 $str2"

        binding.txtRes.text = "New String: $resultStr"
        binding.txtRes.append("\nAverage is $resultingAvg")

        binding.button.setOnClickListener{
            finish()
        }

    }
}