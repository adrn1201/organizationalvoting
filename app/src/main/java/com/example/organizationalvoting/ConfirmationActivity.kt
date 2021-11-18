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
    private val conn by lazy {binding.txtCon}
    private var confirmation = "Confirmation"
    private  var end = "Thank you!"
    //private  var time = "${Calendar.getInstance().time}"

    private lateinit var binding: ActivityConfirmationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun randomAlphanumericString(): String {
            val charPool: List<Char> = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            val outputStrLength = (45..100).shuffled().first()

            return (45..outputStrLength)
                .map{ kotlin.random.Random.nextInt(45, charPool.size) }
                .map(charPool::get)
                .joinToString("")
        }


        val enteredfName = intent.getStringExtra(FNAME)
        val enteredlName = intent.getStringExtra(LNAME)

        confirmation = "Confirmation: " + "#" + randomAlphanumericString()
        end = "Thank you! $enteredfName $enteredlName"

        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

        binding.txtDate.text = formatter.format(Date())
        conn.text = confirmation
        message.text = end
        //date.text = time




        binding.btnDone.setOnClickListener {
            val intent = Intent ( this, MainActivity::class.java)
            intent.putExtra(FNAME, LNAME)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
}