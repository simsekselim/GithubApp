package com.selimsimsek.data.utils

import com.selimsimsek.data.di.ApplicationScope
import com.selimsimsek.data.utils.Constants.CONTENT_TYPE
import com.selimsimsek.data.utils.Constants.KET_AUTH
import com.selimsimsek.data.utils.Constants.TYPE_VALUE
import com.selimsimsek.data.utils.Constants.VALUE_AUTH
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Interceptor @Inject constructor(
    @ApplicationScope private val scope: CoroutineScope
) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader(KET_AUTH, VALUE_AUTH)
        request.addHeader(CONTENT_TYPE, TYPE_VALUE)
        return chain.proceed(request = request.build())
    }

}