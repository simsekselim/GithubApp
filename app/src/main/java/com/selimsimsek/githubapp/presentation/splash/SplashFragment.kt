package com.selimsimsek.githubapp.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.selimsimsek.githubapp.R
import com.selimsimsek.githubapp.databinding.FragmentSplashBinding
import com.selimsimsek.githubapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>(
    R.layout.fragment_splash,
    SplashViewModel::class.java
) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        CoroutineScope(Dispatchers.Main).launch {

            delay(2500)
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)


        }

    }


}