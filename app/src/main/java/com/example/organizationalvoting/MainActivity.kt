package com.example.organizationalvoting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.organizationalvoting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userId by lazy {binding.userNumber}
    private val section by lazy {binding.userSection}
    private val fName by lazy {binding.userFname}
    private val lName by lazy {binding.userLname}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLog.setOnClickListener { sendData() }
    }

    private fun sendData() {
        val userIdStr = userId.text.toString()
        val sectionStr = section.text.toString()
        val fNameStr = fName.text.toString()
        val lNameStr = lName.text.toString()

        if (userIdStr.trim().isNotEmpty() && sectionStr.trim().isNotEmpty() && fNameStr.trim().isNotEmpty() && lNameStr.trim().isNotEmpty()) {
            val intent = Intent(this, VotingActivity::class.java).apply{
                putExtra(F_NAME, fNameStr)
                putExtra(L_NAME, lNameStr)
            }
            startActivity(intent)
        }else {
            Toast.makeText(applicationContext, getString(R.string.empty_register), Toast.LENGTH_SHORT).show()
        }
    }
}