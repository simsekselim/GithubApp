package com.selimsimsek.githubapp.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.selimsimsek.domain.model.RepositoryItem
import com.selimsimsek.domain.model.UserModel
import com.selimsimsek.domain.repository.GithubRepository
import com.selimsimsek.githubapp.presentation.base.BaseViewModel
import com.selimsimsek.githubapp.presentation.home.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository : GithubRepository,
    state : SavedStateHandle
): BaseViewModel() {

    val user = MutableLiveData<UserModel>()
    val item = MutableLiveData<List<RepositoryItem>>()

    val username = MutableLiveData(USERNAME)


 //   val username: String = state.get("username") ?: ""

    init {
        profile()
        userRepository()
    }

    fun profile(){
        val username = username.value.toString()
        sendRequest(
            request = {repository.detailUser(username)},
            success = {
                user.value = it
            }
        )
    }
    private fun userRepository(){
        val username = username.value.toString()
        sendRequest(
            request = {repository.userRepo(username)},
            success = {
                item.value = it
            }
        )
    }
    companion object {
        const val USERNAME = "simsekselim"
    }
}