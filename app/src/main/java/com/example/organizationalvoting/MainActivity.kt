package com.example.organizationalvoting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.organizationalvoting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var startForResult: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
           validateIntent(result)
        }

        val firstName = findViewById<EditText>(R.id.user_Fname)
        val lastName = findViewById<EditText>(R.id.user_Lname)
        val studentNumber = findViewById<EditText>(R.id.user_Number)
        val section = findViewById<EditText>(R.id.user_Section)

        binding.btnLog.setOnClickListener {
            val fName = firstName.text.toString()
            val lName = lastName.text.toString()
            val sNumber = studentNumber.text.toString()
            val uSection = section.text.toString()

            if(fName.trim().isNotEmpty() && lName.trim().isNotEmpty() && sNumber.trim().isNotEmpty() && uSection.trim().isNotEmpty()) {
                val intent = Intent (this, VotingActivity::class.java)
                intent.putExtra(FNAME, fName)
                intent.putExtra(LNAME, lName)
                startForResult.launch(intent)
            }else{
                Toast.makeText(applicationContext, "Please fill up all the fields", Toast.LENGTH_SHORT).show()
            }

        }

    }
    private fun validateIntent(result: ActivityResult) {
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
        }
    }
}