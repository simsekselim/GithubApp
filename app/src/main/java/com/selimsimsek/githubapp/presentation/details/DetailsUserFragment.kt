package com.selimsimsek.githubapp.presentation.details

import com.selimsimsek.githubapp.R
import com.selimsimsek.githubapp.databinding.FragmentDetailsUserBinding
import com.selimsimsek.githubapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsUserFragment : BaseFragment<DetailUserViewModel, FragmentDetailsUserBinding>(
    R.layout.fragment_details_user,
    DetailUserViewModel::class.java
)