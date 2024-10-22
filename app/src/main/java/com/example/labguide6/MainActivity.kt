package com.example.labguide6

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.labguide6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSecond.setOnClickListener{
            var intent = Intent(this@MainActivity, SecondActivity::class.java)
            val num1 = binding.editNum1.text.toString().toInt()
            val num2 = binding.editNum2.text.toString().toInt()
            val num3 = binding.editNum3.text.toString().toInt()
            val str1 = binding.editSTR1.text.toString()
            val str2 = binding.editSTR2.text.toString()
            val b = Bundle()
            b.putInt("num1", num1)
            b.putInt("num2", num2)
            b.putInt("num3", num3)
            b.putString("str1", str1)
            b.putString("str2", str2)
            intent.putExtras(b)
            startActivity(intent)
        }
    }
}