package com.selimsimsek.githubapp.presentation.login

import com.selimsimsek.githubapp.R
import com.selimsimsek.githubapp.databinding.FragmentLoginBinding
import com.selimsimsek.githubapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    R.layout.fragment_login,
    LoginViewModel::class.java
)
