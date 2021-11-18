package com.example.organizationalvoting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.organizationalvoting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnLog.setOnClickListener {
            //var coinz = inputCoin.text.toString()
            val intent = Intent ( this, ConfirmationActivity::class.java)
            intent.putExtra(USERNAME, NAMEUSER)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
}