package com.example.ragistrationformapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ragistrationformapp.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    lateinit var user: User
    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrieveUser()
        displayUser()
        setupClickListeners()

    }

    private fun retrieveUser() {
        user = intent.getSerializableExtra("User") as User
    }

    private fun displayUser() {
        binding.textViewUserFullName.text = user.getFullName()
        binding.textViewEmailAddress.text = user.email
        binding.textViewPhoneNo.text = user.phoneNo
    }

    private fun setupClickListeners() {
        binding.textViewEmailAddress.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }

        binding.textViewPhoneNo.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(("tel:${user.phoneNo}"))
            startActivity(intent)
        }
    }
}
