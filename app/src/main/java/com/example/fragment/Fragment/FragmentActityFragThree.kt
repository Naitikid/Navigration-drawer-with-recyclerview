package com.example.fragment.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentActityFragThreeBinding

class FragmentActityFragThree : Fragment() {
    private lateinit var binding: FragmentActityFragThreeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as FragmentClickActivity).supportActionBar?.title="This is Third Fragment"
        binding = FragmentActityFragThreeBinding.inflate(inflater, container, false)
        binding.btnNextFragmentthird.setOnClickListener{

            activity?.onBackPressed()
        }
        return binding.root
    }
}

