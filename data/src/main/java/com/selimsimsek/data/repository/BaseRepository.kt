package com.selimsimsek.data.repository


import com.google.gson.Gson
import com.selimsimsek.data.remote.exceptions.Authentication
import com.selimsimsek.data.remote.exceptions.GettingEmptyListItem
import com.selimsimsek.data.remote.exceptions.SimpleHttpException
import com.selimsimsek.data.remote.exceptions.Unauthorized
import com.selimsimsek.domain.model.ErrorControl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import retrofit2.HttpException


abstract class BaseRepository {

    suspend fun <T : Any> execute(request: suspend () -> T): T {
        try {
            return request.invoke()
        } catch (ex: Exception) {
            throw parseException(ex)
        }
    }

    open suspend fun <T> fetchFromLocal(cached: suspend () -> T?): T? {
        return try {
            cached.invoke()
        } catch (ex: Exception) {
            throw parseException(ex)
        }
    }

    open suspend fun saveToLocal(store: suspend () -> Unit) {
        try {
            withContext(Dispatchers.IO) {
                store.invoke()
            }
        } catch (ex: Exception) {
            throw parseException(ex)
        }
    }

    private fun parseException(ex: Exception): Exception {

        return when (ex) {
            // cast HttpException here.
            is HttpException -> {
                when (ex.response()?.code()) {
                    CODE_UNAUTHORISED -> Unauthorized()
                    CODE_AUTHENTICATION -> Authentication()
                    else -> {
                        val response = Gson().fromJson(
                            ex.response()?.errorBody()?.charStream(),
                            ErrorControl::class.java
                        )
                        SimpleHttpException(response.code, response.error)
                    }
                }
            }
            is IndexOutOfBoundsException -> GettingEmptyListItem()
            else -> ex
        }
    }

    companion object {
        private const val CODE_AUTHENTICATION = 403
        private const val CODE_UNAUTHORISED = 401
    }
}