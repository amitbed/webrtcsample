package com.developerspace.webrtcsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.symm.webrtcsample.databinding.FragmentTouchTrackerBinding

class TouchTrackerFragment : Fragment() {
    private lateinit var binding: FragmentTouchTrackerBinding

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[TouchViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTouchTrackerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.trackerView.setSendDataListener(object : TouchTrackerView.TouchDataListener {
            override fun onSendTouchData(touchPoints: List<TouchPoint>) {
                viewModel.updateLocalTouchPoints(touchPoints)
            }
        })

        viewModel.remoteTouchPoints.observe(this) { touches ->
            binding.trackerView.displayRemoteTouches(touches)
        }
    }
}