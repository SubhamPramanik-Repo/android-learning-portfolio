package com.example.activitylifecycleplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.activitylifecycleplayground.databinding.ActivityFragmentPlaygroundBinding
import java.io.File

class FragmentActivityPlayground : AppCompatActivity(), TestFragment.TestFragmentListener {
    val TAG = "Fragment_Activity_LifeCycle"

    val testFragment = TestFragment()
    private lateinit var binding: ActivityFragmentPlaygroundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentPlaygroundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonShowFragment.setOnClickListener { showfragment() }
        binding.buttonRemoveFragment.setOnClickListener { removefragment() }


        binding.buttonSaveMessageFragment.setOnClickListener { saveMessage() }
        binding.textViewSavedMessageFragment.text = savedInstanceState?.getString("savedMessage")

    }


    private fun FragmentActivityPlayground.showfragment() {

        supportFragmentManager.commit {
            replace(R.id.fragment_container, testFragment)
        }
    }

    private fun FragmentActivityPlayground.removefragment() {
        supportFragmentManager.commit {
            remove(testFragment)
        }
    }

    private fun saveMessage() {
        val userMessage = binding.editTextMessageFragment.text
        File(filesDir, "User_Message.txt").writeText(userMessage.toString())

        binding.textViewSavedMessageFragment.text = "Your message has been saved!\n\nMessage Preview: \n\n$userMessage"

        binding.editTextMessageFragment.setText("")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val savedTextViewMessage = binding.textViewSavedMessageFragment.text.toString()

        outState.putString("savedMessage",savedTextViewMessage)
    }

    override fun clearActivityScreen() {
        binding.editTextMessageFragment.setText("")
        binding.textViewSavedMessageFragment.text = ""

        removefragment()

    }
}

