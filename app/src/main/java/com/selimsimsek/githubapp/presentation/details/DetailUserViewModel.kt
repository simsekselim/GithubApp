package com.selimsimsek.githubapp.presentation.details

import com.selimsimsek.domain.repository.GithubRepository
import com.selimsimsek.githubapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailUserViewModel @Inject constructor(
    private val repository: GithubRepository
): BaseViewModel() {

    fun detailUser(username : String){
        sendRequest(
            request = {repository.detailUser(username)},
            success = {}
        )
    }
}