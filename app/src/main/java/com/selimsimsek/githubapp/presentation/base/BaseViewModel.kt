package com.selimsimsek.githubapp.presentation.base

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.selimsimsek.data.remote.exceptions.Authentication
import com.selimsimsek.data.remote.exceptions.GettingEmptyListItem
import com.selimsimsek.data.remote.exceptions.SimpleHttpException
import com.selimsimsek.githubapp.R
import com.selimsimsek.githubapp.utils.SingleLiveEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

abstract class BaseViewModel : ViewModel(){

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> get() = _loading

    val baseEvent = SingleLiveEvent<BaseViewEvent>()

    fun navigate(directions: NavDirections) {
        baseEvent.value = BaseViewEvent.NavigateTo(directions)
    }

    fun popBackStack() {
        baseEvent.value = BaseViewEvent.NavigateBack
    }


    fun showMessage(message: String) {
        baseEvent.value = BaseViewEvent.ShowMessage(message)
    }

    fun showMessage(@StringRes message: Int) {
        baseEvent.value = BaseViewEvent.ShowMessage(message)
    }

    private fun showDialog() {
        _loading.value = true
    }

    private fun dismissDialog() {
        _loading.value = false
    }

    fun <T> sendRequest(
        loading: Boolean = false,
        request: suspend () -> T,
        success: (suspend (T) -> Unit)? = null,
        error: ((Exception) -> Unit)? = null
    ): Job {
        return viewModelScope.launch {
            if (loading) showDialog()
            try {
                val response = request.invoke()
                success?.invoke(response)
                dismissDialog()
            } catch (ex: Exception) {
                dismissDialog()
                if (error == null)
                    handleException(ex)
                else error.invoke(ex)
            }
        }
    }

    private fun handleException(ex: Exception) {
        when (ex) {
            is Authentication -> showMessage(R.string.try_again)
            is IOException -> showMessage(R.string.check_internet)
            is GettingEmptyListItem -> showMessage(R.string.no_comment)
            is SimpleHttpException -> ex.friendlyMessage?.let { showMessage(it) }

        }
    }
}