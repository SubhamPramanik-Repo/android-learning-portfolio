package com.example.activitylifecycleplayground

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylifecycleplayground.databinding.ActivityMainBinding
import java.io.File
import java.util.Timer
import kotlin.concurrent.fixedRateTimer
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    val TAG = "Activity_LifeCycle"
    private lateinit var binding: ActivityMainBinding
    private var isFirstLoad: Boolean = true
    private var numberOfLoadings = 0
    var seconds = 0
    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonExit.setOnClickListener {
            Log.d(TAG, "In the **Button ClickListener**.")
//            finish()
//            startActivity(Intent(this, ANonFullScreenActivity::class.java))
            showDialog()
        }

//        binding.textViewRefreshStatus.text = "Welcome to the App! Here is your refresh feed..."

        onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(this@MainActivity, "Back Button Pressed", Toast.LENGTH_LONG).show()
//          finish()
            showDialog()
        }

        binding.buttonSaveMessage.setOnClickListener { saveMessage() }

        binding.textViewSavedMessage.text = savedInstanceState?.getString("savedMessage")

        binding.buttonFragmentLifecyclePlayground.setOnClickListener { clickFragmentLifecyclePlayground() }

        Log.d(TAG, "In the **onCreate()** method.")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val savedTextViewMessage = binding.textViewSavedMessage.text.toString()

        outState.putString("savedMessage",savedTextViewMessage)
    }


    //When our Activity Becomes Visible
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "In the **onStart()** method.")

    }

    //When our Activity in The FOREGROUND
    override fun onResume() {
        super.onResume()

        numberOfLoadings++

        if (isFirstLoad) {
            binding.textViewRefreshStatus.text = "Welcome to the App! Here is your refresh feed..."
            isFirstLoad = false

        } else {
            binding.textViewRefreshStatus.text = "Your feed has been updated..."
        }

        timer = fixedRateTimer(period = 1000L) {
            runOnUiThread {
                seconds++
                binding.textViewTimerStatus.text =
                    "You have been starting at this screen for $seconds seconds!"
            }
        }

        Log.d(TAG, "In the **onResume()** method. numberOfLoadings: $numberOfLoadings")
    }

    //When our Activity is still Visible but in The BACKGROUND (e.g. An Activity 'Dialog' is on top, but we can see our Activity)
    override fun onPause() {
        super.onPause()

        timer.cancel()

        Log.d(TAG, "In the **onPause()** method.")
    }

    //When our Activity is no Longer Visible but still RUNNING
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "In the **onStop()** method.")

    }

    override fun onRestart() {
        super.onRestart()
        numberOfLoadings++
        binding.textViewRefreshStatus.text = "Your feed has been updated..."

        Log.d(TAG, "In the **onRestart()** method. numberOfLoadings: $numberOfLoadings")

    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "In the **onDestroy()** method.")
    }

    private fun showDialog() {
//        val myDialog = AlertDialog.Builder(this)
//        myDialog.setTitle("")
//        myDialog.setMessage("")
//        myDialog.show()


//        AlertDialog.Builder(this).setTitle("Sure, you want to leave!").setMessage("This is my mes").show()

        AlertDialog.Builder(this)
            .setTitle("Warning!")
//            .setMessage("Are you sure, you want to exit?")
            .setView(R.layout.dialog_warning)
            .setPositiveButton("Yes") { _, _ ->
                finish()
            }
            .setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            .setNeutralButton("More Info") { dialog, _ ->
                Toast.makeText(
                    this,
                    "This is where the more info screen would be!",
                    Toast.LENGTH_LONG
                ).show()
                dialog.dismiss()
            }
            .show()
    }

    private fun saveMessage() {
        val userMessage = binding.editTextMessage.text
        File(filesDir, "User_Message.txt").writeText(userMessage.toString())

        binding.textViewSavedMessage.text = "Your message has been saved!\n\nMessage Preview: \n\n$userMessage"

        binding.editTextMessage.setText("")
    }

    private fun clickFragmentLifecyclePlayground(){
        val intent = Intent(this, FragmentActivityPlayground::class.java)
        startActivity(intent)
    }


}
