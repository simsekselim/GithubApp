package com.selimsimsek.githubapp.presentation.webview

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.selimsimsek.data.utils.Constants.URL_DATA
import com.selimsimsek.githubapp.R
import com.selimsimsek.githubapp.databinding.FragmentWebViewBinding
import com.selimsimsek.githubapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewFragment : BaseFragment<WebViewViewModel, FragmentWebViewBinding>(
    R.layout.fragment_web_view,
    WebViewViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            it.getString(URL_DATA)?.let { url ->
                with(binding.webView) {
                    loadUrl(url)
                    settings.javaScriptEnabled = true
                    settings.setNeedInitialFocus(true)
                    webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)

                        }
                    }
                }
            }
        }
    }
}