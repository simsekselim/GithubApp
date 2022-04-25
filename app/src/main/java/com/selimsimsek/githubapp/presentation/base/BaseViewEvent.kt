package com.selimsimsek.githubapp.presentation.base

import androidx.navigation.NavDirections

sealed class BaseViewEvent {
    data class NavigateTo(val directions: NavDirections) : BaseViewEvent()
    object NavigateBack : BaseViewEvent()
    data class ShowMessage(val message: Any) : BaseViewEvent()
}