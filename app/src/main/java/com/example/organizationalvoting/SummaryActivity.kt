package com.example.organizationalvoting

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import com.example.organizationalvoting.databinding.ActivitySummaryBinding

import java.util.*

class SummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding
    private var president: String? = ""
    private var vp: String? = ""
    private var secretary: String? = ""
    private var treasurer: String? = ""
    private var pro: String? = ""
    private var fName: String? = ""
    private var lName: String? =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayData()
        initializeComponents()
    }

    private fun getData() {
        president = intent.getStringExtra(INPUT_PRESIDENT)
        vp = intent.getStringExtra(INPUT_VP)
        secretary = intent.getStringExtra(INPUT_SECRETARY)
        treasurer = intent.getStringExtra(INPUT_TREASURER)
        pro = intent.getStringExtra(INPUT_PRO)
        fName = intent.getStringExtra(F_NAME)
        lName = intent.getStringExtra(L_NAME)
    }

    private fun displayData() {
        getData()
        binding.dateTime.text = "${Calendar.getInstance().time}"
        binding.president.text = president
        binding.vicePresident.text = vp
        binding.secretary.text = secretary
        binding.treasurer.text = treasurer
        binding.PRO.text = pro
    }

    private fun initializeComponents() {
        binding.btnNextConfirm.setOnClickListener { sendData() }
        binding.btnBackVote.setOnClickListener { returnData() }
    }

    private fun sendData() {
        val intent = Intent(this, ConfirmationActivity::class.java).apply {
            putExtra(F_NAME, fName)
            putExtra(L_NAME, lName)
        }
        startActivity(intent)
    }

    private fun returnData() {
        val data = Intent()
        data.putExtra(INPUT_PRESIDENT, president)
        data.putExtra(INPUT_VP, vp)
        data.putExtra(INPUT_SECRETARY, secretary)
        data.putExtra(INPUT_TREASURER, treasurer)
        data.putExtra(INPUT_PRO, pro)
        setResult(RESULT_OK, data)
        super.finish()
    }
}