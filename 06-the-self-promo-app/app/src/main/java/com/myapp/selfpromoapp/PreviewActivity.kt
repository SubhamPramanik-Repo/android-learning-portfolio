package com.myapp.selfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.myapp.selfpromoapp.databinding.ActivityPreviewBinding
import java.net.URI
import androidx.core.net.toUri


class PreviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreviewBinding

    private lateinit var message: Message
    private lateinit var messagePreviewTest: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDisplayMessage()

        setupButton()


//        val contactName = intent.getStringExtra("Contact Name")
//        val contactNumber = intent.getStringExtra("Contact Number")
//        val displayName = intent.getStringExtra("Display Name")
//        val startDate = intent.getStringExtra("Start Date")
//        val includeJunior = intent.getBooleanExtra("Include Junior", false)
//        val immediateJoin = intent.getBooleanExtra("Immediate Join", false)
//        val jobTitle = intent.getStringExtra("Job Title")

//        var test = "contactName: $contactName\ncontactNumber: $contactNumber\ndisplayName: $displayName\nstartDate: $startDate\nincludeJunior: $includeJunior\nimmediateJoin: $immediateJoin\njobTitle: $jobTitle"
//        binding.textViewMessage.text = test
    }

    private fun myDisplayMessage() {
        message = intent.getSerializableExtra("Message") as Message

        messagePreviewTest = """
                        Hi ${message.contactName},
                        
                        My name is ${message.displayName} and I am ${message.getFullJobDescription()}
                        
                        I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                        
                        I am able to start a new position ${message.getFullJobDescription()}
                        
                        Please get in touch if you have any suitable role for me.
                        
                        Thanks and best regards.
                        ${message.displayName} 
                    """.trimIndent()

        binding.textViewMessage.text = messagePreviewTest
    }

    private fun setupButton() {
        binding.buttonSendMessage.setOnClickListener {
            try {
                val sendMsgToWhatsAppIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = "https://wa.me/${message.contactNumber}?text=${
                        Uri.encode(messagePreviewTest)
                    }".toUri()

                    `package` = "com.whatsapp"
                }
                startActivity(sendMsgToWhatsAppIntent)
            } catch (e: Exception){
                val sendMsgToSMSIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("smsto:${message.contactNumber}")
                    putExtra("sms_body", messagePreviewTest)
                }
                startActivity(sendMsgToSMSIntent)
            }
        }
    }
}