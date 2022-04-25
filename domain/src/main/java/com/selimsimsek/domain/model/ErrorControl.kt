package com.selimsimsek.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorControl(
    val code: String,
    val error: String
) : Parcelable