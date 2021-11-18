package com.example.organizationalvoting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.organizationalvoting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = findViewById<EditText>(R.id.user_Fname)
        val lastName = findViewById<EditText>(R.id.user_Lname)
        val studentNumber = findViewById<EditText>(R.id.user_Number)
        val section = findViewById<EditText>(R.id.user_Section)


        binding.btnLog.setOnClickListener {
            var fName = firstName.text.toString()
            var lName = lastName.text.toString()
            var sNumber = studentNumber.text.toString()
            var uSection = section.text.toString()


            if(fName.trim().isNotEmpty() && lName.trim().isNotEmpty() && sNumber.trim().isNotEmpty() && uSection.trim().isNotEmpty()) {
                val intent = Intent ( this, VotingActivity::class.java)
                intent.putExtra(FNAME, fName)
                intent.putExtra(LNAME, lName)
                startActivityForResult(intent, REQUEST_CODE)
            }

            else{

                Toast.makeText(applicationContext, "Please fill up all the fields", Toast.LENGTH_SHORT).show()
            }

        }
    }
}