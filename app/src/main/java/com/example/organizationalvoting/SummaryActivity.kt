package com.example.organizationalvoting

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.organizationalvoting.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val president = intent.getStringExtra(INPUT_PRESIDENT)
        val vp = intent.getStringExtra(INPUT_VP)
        val secretary = intent.getStringExtra(INPUT_SECRETARY)
        val treasurer = intent.getStringExtra(INPUT_TREASURER)
        val pro = intent.getStringExtra(INPUT_PRO)

        binding.president.text = president
        binding.vicePresident.text = vp
        binding.secretary.text = secretary
        binding.treaasurer.text = treasurer
        binding.PRO.text = pro



    }


}