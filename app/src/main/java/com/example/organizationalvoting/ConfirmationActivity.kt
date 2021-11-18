package com.example.organizationalvoting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.organizationalvoting.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btndone.setOnClickListener {
            //var coinz = inputCoin.text.toString()
            val intent = Intent ( this, MainActivity::class.java)
            intent.putExtra(USERNAME, NAMEUSER)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
}