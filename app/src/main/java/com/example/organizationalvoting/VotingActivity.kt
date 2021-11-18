package com.example.organizationalvoting

import android.R.layout.simple_spinner_item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.organizationalvoting.databinding.ActivityVotingBinding
import com.example.organizationalvoting.viewModel.ViewModel
import com.google.android.material.snackbar.Snackbar

class VotingActivity : AppCompatActivity() {
    private lateinit var startForResult: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityVotingBinding
    private val spinnerPresident by lazy { binding.spinnerPresident }
    private val spinnerVp by lazy { binding.spinnerVP }
    private val spinnerSecretary by lazy { binding.spinnerSecretary }
    private val spinnerTreasurer by lazy { binding.spinnerTreasurer }
    private val spinnerPro by lazy { binding.spinnerPro }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVotingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
           result: ActivityResult -> validateIntent(result)
        }

        binding.btnBackRegister.setOnClickListener {
            val intent = Intent ( this, MainActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        val viewModel by viewModels<ViewModel>()
        displayData(viewModel)
        initializeComponents()

    }

    private fun validateIntent(result: ActivityResult) {
       if (result.resultCode == RESULT_OK) {
          val intent = result.data?.getStringExtra(RETURN_PRESIDENT)
           //binding.spinnerPresident.set(intent.toString())
           /*Snackbar.make(binding.editCoinAmount,
               getString(R.string.snackBar_main, intent), Snackbar.LENGTH_SHORT).show()*/
      }
   }

    private fun displayData(viewModel: ViewModel) {
        viewModel.president.observe(this) {
            getData(it, spinnerPresident)
        }
        viewModel.vicePresident.observe(this) {
            getData(it, spinnerVp)
        }
        viewModel.secretary.observe(this) {
            getData(it, spinnerSecretary)
        }
        viewModel.treasurer.observe(this) {
            getData(it, spinnerTreasurer)
        }
        viewModel.pro.observe(this) {
            getData(it, spinnerPro)
        }
    }

    private fun getData(it: Array<String>, spinner:Spinner) {
        val adapter = ArrayAdapter(this, simple_spinner_item, it)
        spinner.adapter = adapter
    }

    private fun initializeComponents() {
        spinnerPresident.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {}
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        binding.btnNextSum.setOnClickListener{
            val intent = Intent(this, SummaryActivity::class.java)

            val getPresInput = binding.spinnerPresident.selectedItem.toString()
            val getVpInput = binding.spinnerVP.selectedItem.toString()
            val getSecretaryInput = binding.spinnerSecretary.selectedItem.toString()
            val getTreasurerInput = binding.spinnerSecretary.selectedItem.toString()
            val getProInput = binding.spinnerPro.selectedItem.toString()

            intent.putExtra(INPUT_PRESIDENT, getPresInput)
            intent.putExtra(INPUT_VP, getVpInput)
            intent.putExtra(INPUT_SECRETARY, getSecretaryInput)
            intent.putExtra(INPUT_TREASURER, getTreasurerInput)
            intent.putExtra(INPUT_PRO, getProInput)
            startForResult.launch(intent)
        }
    }
}