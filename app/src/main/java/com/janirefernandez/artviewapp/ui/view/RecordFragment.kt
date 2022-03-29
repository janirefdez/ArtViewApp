package com.janirefernandez.artviewapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.janirefernandez.artviewapp.R
import com.janirefernandez.artviewapp.databinding.FragmentRecordBinding
import com.janirefernandez.artviewapp.ui.kits.UINavigationBarKit
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RecordFragment : Fragment() {

    private lateinit var fragmentRecordBinding: FragmentRecordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentRecordBinding = FragmentRecordBinding.inflate(layoutInflater)
        loadWebView(requireArguments().getString(MainActivity.URL_BUNDLE)!!)

        UINavigationBarKit.enableDisplayHomeAsUp(
            (activity as AppCompatActivity).supportActionBar!!,
            requireArguments().getString(MainActivity.TITLE_BUNDLE)!!
        )
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

    override fun onDestroy() {
        UINavigationBarKit.disableDisplayHomeAsUp(
            (activity as AppCompatActivity).supportActionBar!!,
            getString(R.string.title)
        )
        super.onDestroy()
    }
}