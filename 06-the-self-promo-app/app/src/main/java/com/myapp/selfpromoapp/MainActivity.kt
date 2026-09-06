package com.myapp.selfpromoapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.google.android.material.textfield.TextInputEditText
import com.myapp.selfpromoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val TAG: String = "SelfPromoApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer", "Software Engineer")
        val spinnerAdepter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spinnerJobTitle.adapter = spinnerAdepter

    }

    private fun onPreviewClicked() {
//        Log.d(TAG, "contactNameEditText: " + binding.editTextContactName.text.toString())
//        val textString: String = "Conatct Name: ${binding.editTextContactName.text.toString()},Contact Number: ${binding.editTextContactNumber.text.toString()},Display Name: ${binding.editTextMyDisplayName.text.toString()},Include Junior: ${binding.checkBoxJunior.isChecked},Job Title: ${binding.spinnerJobTitle.selectedItem},Immediate Join: ${binding.checkBoxImmediateJoin.isChecked},Available Date: ${binding.editTextStartDate.text.toString()} "
//        Toast.makeText(this, textString, Toast.LENGTH_LONG).show()

//        val contactName = binding.editTextContactName.text.toString()
//        val contactNumber = binding.editTextContactNumber.text.toString()
//        val displayName = binding.editTextMyDisplayName.text.toString()
//        val startDate = binding.editTextStartDate.text.toString()
//        val isJunior = binding.checkBoxJunior.isChecked
//        val immediateJoin = binding.checkBoxImmediateJoin.isChecked
//        val jobTitle = binding.spinnerJobTitle.selectedItem?.toString()

        val message = Message(
            binding.editTextContactName.text.toString(),
            binding.editTextContactNumber.text.toString(),
            binding.editTextMyDisplayName.text.toString(),
            binding.editTextStartDate.text?.toString(),
            binding.checkBoxJunior.isChecked,
            binding.checkBoxImmediateJoin.isChecked,
            binding.spinnerJobTitle.selectedItem?.toString()
        )

//        Log.d(
//            TAG,
//            "contactName: $contactName\ncontactNumber: $contactNumber\ndisplayName: $displayName\nstartDate: $startDate\nisJunior: $isJunior\nimmediateJoin: $immediateJoin\njobTitle: $jobTitle"
//        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)

//        previewActivityIntent.putExtra("Contact Name", contactName)
//        previewActivityIntent.putExtra("Contact Number", contactNumber)
//        previewActivityIntent.putExtra("Display Name", displayName)
//        previewActivityIntent.putExtra("Start Date", startDate)
//        previewActivityIntent.putExtra("Include Junior", isJunior)
//        previewActivityIntent.putExtra("Immediate Join", immediateJoin)
//        previewActivityIntent.putExtra("Job Title", jobTitle)

        previewActivityIntent.putExtra("Message", message)

        startActivity(previewActivityIntent)

    }
}

