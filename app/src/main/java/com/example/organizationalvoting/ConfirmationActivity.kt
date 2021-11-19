package com.example.organizationalvoting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.organizationalvoting.databinding.ActivityConfirmationBinding
import java.util.*

class ConfirmationActivity : AppCompatActivity() {
    private val confirmation by lazy {binding.txtCon}
    private val message by lazy {binding.txtMessage}
    private var fName: String? = ""
    private var lName: String? =""
    private lateinit var binding: ActivityConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayData()
        binding.btnDone.setOnClickListener{ redirectToHome() }
    }

    private fun getUserData() {
        fName = intent.getStringExtra(F_NAME)
        lName = intent.getStringExtra(L_NAME)
    }

    private fun displayData() {
        val randomString = UUID.randomUUID().toString().substring(0,4)
        getUserData()
        binding.txtDate.text = "${Calendar.getInstance().time}"
        confirmation.text = getString(R.string.reference, randomString)
        message.text = getString(R.string.thank_you, fName, lName)
    }

    private fun redirectToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}