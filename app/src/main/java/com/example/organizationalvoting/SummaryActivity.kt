package com.example.organizationalvoting

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.organizationalvoting.databinding.ActivitySummaryBinding
import java.text.SimpleDateFormat

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class SummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding
    private var testAgain: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val president = intent.getStringExtra(INPUT_PRESIDENT)
        val vp = intent.getStringExtra(INPUT_VP)
        val secretary = intent.getStringExtra(INPUT_SECRETARY)
        val treasurer = intent.getStringExtra(INPUT_TREASURER)
        val pro = intent.getStringExtra(INPUT_PRO)
        testAgain = intent.getStringExtra(FNAME)

        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

        binding.dateTime.text = formatter.format(Date())

        binding.president.text = president
        binding.vicePresident.text = vp
        binding.secretary.text = secretary
        binding.treaasurer.text = treasurer
        binding.PRO.text = pro

        binding.btnNextConfirm.setOnClickListener {
            val intent = Intent ( this, ConfirmationActivity::class.java)
            intent.putExtra(FNAME, testAgain)
            startActivityForResult(intent, REQUEST_CODE)
        }

        binding.btnBackVote.setOnClickListener {
            val data = Intent()
            data.putExtra(RETURN_PRESIDENT, president)
            setResult(Activity.RESULT_OK, data)
            super.finish()
        }


    }


}