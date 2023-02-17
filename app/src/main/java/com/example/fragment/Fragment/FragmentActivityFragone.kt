package com.example.fragment.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.R
import com.example.fragment.databinding.FragmentActityFragThreeBinding
import com.example.fragment.databinding.FragmentActivityFragoneBinding


class FragmentActivityFragone : Fragment() {
    private lateinit var binding: FragmentActivityFragoneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActivityFragoneBinding.inflate(inflater, container, false)
        binding.btnNextFragmentone.setOnClickListener {
            replacefragment(FragmentActivityFraTwo())
            getActivity()?.setTitle("Sencond Fragment")
        }
        return binding.root
    }

    private fun replacefragment(fragment: Fragment) {
        val tp = fragmentManager?.beginTransaction()
        tp?.add(R.id.framentActivity, fragment,"This is Second Fragment")
        tp?.addToBackStack("second")
        tp?.commitAllowingStateLoss()
        /*getActivity()?.setTitle("kunj")*/
    }


}