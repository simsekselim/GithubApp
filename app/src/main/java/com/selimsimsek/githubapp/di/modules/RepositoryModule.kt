package com.selimsimsek.githubapp.di.modules

import android.content.Context
import com.selimsimsek.data.remote.service.APIService
import com.selimsimsek.data.repository.DefaultGithubRepository
import com.selimsimsek.domain.repository.GithubRepository
import com.selimsimsek.githubapp.utils.DeviceConnection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideDeviceConnection(
        @ApplicationContext context: Context
    ): DeviceConnection = DeviceConnection(context)

    @Provides
    @Singleton
    fun provideGithubRepository(
        service: APIService,
    ): GithubRepository {
        return DefaultGithubRepository(service)
    }

}