package com.selimsimsek.githubapp.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.selimsimsek.domain.model.RepositoryItem
import com.selimsimsek.domain.repository.GithubRepository
import com.selimsimsek.githubapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: GithubRepository,
    state : SavedStateHandle
): BaseViewModel() {

    val item = MutableLiveData<List<RepositoryItem>>()
    val username: String = state.get("username") ?: ""


    init {
        home()
    }

    fun home(){
        sendRequest(
            request = {repository.userRepo(username)},
            success = {
                    item.value = it
            }
        )
    }


    fun toSearch(){
        navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
    }

    companion object {
        const val USERNAME = "simsekselim"
    }
}