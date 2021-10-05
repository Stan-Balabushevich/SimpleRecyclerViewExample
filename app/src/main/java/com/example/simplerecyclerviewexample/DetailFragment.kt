package com.example.simplerecyclerviewexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simplerecyclerviewexample.databinding.DetailFragmentBinding

class DetailFragment: Fragment() {

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DetailFragmentBinding.inflate(inflater,container,false)

        val itemSelected = DetailFragmentArgs.fromBundle(requireArguments()).selectedItem

        binding!!.detailText.text = itemSelected.text

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}