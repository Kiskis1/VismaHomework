package com.example.vismahomework.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.vismahomework.R
import com.example.vismahomework.databinding.HistoryFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.history_fragment) {
    private val viewModel: HistoryViewModel by viewModels()

    private var _binding: HistoryFragmentBinding? = null
    private val binding get() = _binding!!

    private var weatherAdapter: WeatherListAdapter? = WeatherListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = HistoryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.apply {
            adapter = weatherAdapter
        }
        binding.backButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        viewModel.getWeather().observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.msgEmptyList.visibility = View.VISIBLE
            } else {
                binding.msgEmptyList.visibility = View.GONE
                weatherAdapter?.swapData(it)
            }

        }

        //weatherAdapter?.swapData(listOf(item))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        weatherAdapter = null
    }

    companion object {
        fun newInstance() = HistoryFragment()
    }
}