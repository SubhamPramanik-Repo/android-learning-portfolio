package com.example.activitylifecycleplayground

import android.content.Context
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.activitylifecycleplayground.databinding.FragmentTestBinding

class TestFragment : Fragment() {
    val TAG = "Fragment_Activity_LifeCycle"
    private lateinit var binding: FragmentTestBinding

    private var fragmentListener: TestFragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentListener = context as TestFragmentListener

        Log.d(TAG, "In the **onAttach()** method.")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "In the **onCreate()** method.")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.d(TAG, "In the **onCreateView()** method.")


        binding = FragmentTestBinding.inflate(layoutInflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewFragmentText.text =
            "We have made it into our new Fragment, this is onViewCreated()"


        binding.buttonClearTheScreenFragment.setOnClickListener {
            fragmentListener?.clearActivityScreen()
        }


        Log.d(TAG, "In the **onViewCreated()** method.")
    }


    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "In the **onDestroy()** method.")
    }


    override fun onDetach() {
        super.onDetach()

        fragmentListener = null

        Log.d(TAG, "In the **onDetach()** method.")
    }

    interface TestFragmentListener {

        fun clearActivityScreen()

    }
}