package com.selimsimsek.githubapp.presentation.login

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.selimsimsek.domain.repository.GithubRepository
import com.selimsimsek.githubapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository : GithubRepository,
    state : SavedStateHandle
): BaseViewModel() {


    val username = MutableLiveData(USERNAME)

    val validation = MediatorLiveData<Boolean>().apply {
            addSource(username) { value = validate() }

        }

        fun onClickLogin() {
            val username = username.value.toString()
            if (validation.value == true) {
                sendRequest(
                    loading = true,
                    request = { repository.detailUser(username) },
                    success = {
                        toHome()
                    }
                )
            }
        }


        private fun toHome() {
            val username = username.value.toString()
            navigate(LoginFragmentDirections.actionLoginFragmentToHome(username))
        }


        private fun validate(): Boolean {
            return !username.value.isNullOrBlank()
        }

        companion object {
            const val USERNAME = "simsekselim"
        }

}