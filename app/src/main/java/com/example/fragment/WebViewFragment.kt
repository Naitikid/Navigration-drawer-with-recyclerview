package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.fragment.databinding.FragmentWebViewBinding


class WebViewFragment : Fragment() {
    private lateinit var binding: FragmentWebViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentWebViewBinding.inflate(inflater, container, false)
        binding.webviewDisplay.loadUrl("https://www.google.com/")
        binding.webviewDisplay.settings.javaScriptEnabled = true
        binding.webviewDisplay.settings.setSupportZoom(true)
    return binding.root
    }
}