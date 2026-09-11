package com.example.ragistrationformapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ragistrationformapp.databinding.ActivityMainBinding
import kotlinx.coroutines.newSingleThreadContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupButton()
    }

    private fun setupSpinner() {
        val titles = arrayOf("Miss", "Mrs", "Mr", "Mx", "Dr", "Prof")
        val titleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titles)
        binding.spinnerTitle.adapter = titleAdapter
    }

    private fun setupButton() {
        binding.buttonCreateAccount.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
        val user = User(
            binding.spinnerTitle.selectedItem as String,
            binding.textInputEditTextFirstName.text.toString(),
            binding.textInputEditTextLastName.text.toString(),
            binding.textInputEditTextEmail.text.toString(),
            binding.textInputEditTextPhoneNo.text.toString(),
            binding.textInputEditTextPassword.text.toString(),
        )

        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)
    }
}