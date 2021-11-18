package com.example.organizationalvoting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.organizationalvoting.databinding.ActivityConfirmationBinding
import java.text.SimpleDateFormat
import java.util.*

class ConfirmationActivity : AppCompatActivity() {

    private val message by lazy {binding.txtMessage}
    private val date by lazy {binding.txtDate}
    private  var end = "Thank you!"
    //private  var time = "${Calendar.getInstance().time}"

    private lateinit var binding: ActivityConfirmationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val enteredfName = intent.getStringExtra(FNAME)
        val enteredlName = intent.getStringExtra(LNAME)

        end = "Thank you! $enteredfName $enteredlName"

        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

        binding.txtDate.text = formatter.format(Date())

        message.text = end
        //date.text = time




        binding.btnDone.setOnClickListener {
            val intent = Intent ( this, MainActivity::class.java)
            intent.putExtra(FNAME, LNAME)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
}