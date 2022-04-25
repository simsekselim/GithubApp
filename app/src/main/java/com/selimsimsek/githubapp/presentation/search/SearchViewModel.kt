package com.selimsimsek.githubapp.presentation.search

import androidx.lifecycle.MutableLiveData
import com.selimsimsek.domain.model.SearchRequest
import com.selimsimsek.domain.repository.GithubRepository
import com.selimsimsek.githubapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: GithubRepository
) : BaseViewModel() {

    val search = MutableLiveData<SearchRequest>()

    fun searchUser(username: String) {
        sendRequest(
            request = { repository.searchUser(username) },
            success = {
                search.value = it
            }
        )
    }


}