package com.example.organizationalvoting

import android.R.layout.simple_spinner_item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.organizationalvoting.databinding.ActivityVotingBinding
import com.example.organizationalvoting.viewModel.VotingViewModel
import com.google.android.material.snackbar.Snackbar

class VotingActivity : AppCompatActivity() {
    private lateinit var startForResult: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityVotingBinding
    private val spinnerPresident by lazy { binding.spinnerPresident }
    private val spinnerVp by lazy { binding.spinnerVP }
    private val spinnerSecretary by lazy { binding.spinnerSecretary }
    private val spinnerTreasurer by lazy { binding.spinnerTreasurer }
    private val spinnerPro by lazy { binding.spinnerPro }
    private val viewModel by viewModels<VotingViewModel>()
    private var fName: String? = ""
    private var lName: String? =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVotingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
           result: ActivityResult -> validateIntent(result)
        }
        displayData(viewModel)
        initializeComponents()
    }

    private fun getData(it: Array<String>, spinner:Spinner) {
        val adapter = ArrayAdapter(this, simple_spinner_item, it)
        spinner.adapter = adapter
    }

    private fun displayData(viewModel: VotingViewModel) {
        viewModel.president.observe(this) { getData(it, spinnerPresident) }
        viewModel.vicePresident.observe(this) { getData(it, spinnerVp) }
        viewModel.secretary.observe(this) { getData(it, spinnerSecretary) }
        viewModel.treasurer.observe(this) { getData(it, spinnerTreasurer) }
        viewModel.pro.observe(this) { getData(it, spinnerPro) }
    }

    private fun initializeComponents() {
        binding.btnNextSum.setOnClickListener{ sendData() }
        binding.btnBackRegister.setOnClickListener { navigateBack() }
    }

    private fun getUserData(){
        fName = intent.getStringExtra(F_NAME)
        lName = intent.getStringExtra(L_NAME)
    }

    private fun sendData() {
        val getPresInput = binding.spinnerPresident.selectedItem.toString()
        val getVpInput = binding.spinnerVP.selectedItem.toString()
        val getSecretaryInput = binding.spinnerSecretary.selectedItem.toString()
        val getTreasurerInput = binding.spinnerSecretary.selectedItem.toString()
        val getProInput = binding.spinnerPro.selectedItem.toString()
        getUserData()

        if (viewModel.validateSelectedItem(getPresInput, getVpInput, getSecretaryInput, getTreasurerInput, getProInput)) {
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra(F_NAME, fName)
            intent.putExtra(L_NAME, lName)
            intent.putExtra(INPUT_PRESIDENT, getPresInput)
            intent.putExtra(INPUT_VP, getVpInput)
            intent.putExtra(INPUT_SECRETARY, getSecretaryInput)
            intent.putExtra(INPUT_TREASURER, getTreasurerInput)
            intent.putExtra(INPUT_PRO, getProInput)
            startForResult.launch(intent)
        }else{
            Snackbar.make(binding.root, getString(R.string.empty_candidate), Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun navigateBack() {
        val data = Intent()
        setResult(RESULT_OK, data)
        super.finish()
    }

    private fun validateIntent(result: ActivityResult) {
       if (result.resultCode == RESULT_OK) {
          result.data?.getStringExtra(RETURN_PRESIDENT)
          result.data?.getStringExtra(RETURN_VP)
          result.data?.getStringExtra(RETURN_Secretary)
          result.data?.getStringExtra(RETURN_Treasurer)
          result.data?.getStringExtra(RETURN_Pro)
      }
   }


}