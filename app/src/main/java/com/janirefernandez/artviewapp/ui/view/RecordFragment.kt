package com.janirefernandez.artviewapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.janirefernandez.artviewapp.databinding.FragmentRecordBinding


class RecordFragment : Fragment() {

    private lateinit var fragmentRecordBinding: FragmentRecordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentRecordBinding = FragmentRecordBinding.inflate(layoutInflater)

        loadWebView(requireArguments().getString("url")!!)

        return fragmentRecordBinding.root
    }

    private fun loadWebView(url: String) {
        fragmentRecordBinding.webView.settings.javaScriptEnabled = true
        fragmentRecordBinding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
                view.loadUrl(url!!)
                return true
            }
        }
        fragmentRecordBinding.webView.loadUrl(url)
    }
}