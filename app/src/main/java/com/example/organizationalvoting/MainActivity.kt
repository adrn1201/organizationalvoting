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

        val firstName = findViewById<EditText>(R.id.user_Fname)
        val lastName = findViewById<EditText>(R.id.user_Lname)

        binding.btnLog.setOnClickListener {
            var fName = firstName.text.toString()
            var lName = lastName.text.toString()

            val intent = Intent ( this, ConfirmationActivity::class.java)
            intent.putExtra(FNAME, fName)
            intent.putExtra(LNAME, lName)


            startActivityForResult(intent, REQUEST_CODE)

        }
    }
}