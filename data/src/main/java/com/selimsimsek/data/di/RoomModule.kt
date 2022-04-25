package com.selimsimsek.data.di

import android.content.Context
import androidx.room.Room
import com.selimsimsek.data.BuildConfig
import com.selimsimsek.data.local.converters.Converter
import com.selimsimsek.data.local.dao.GithubDao
import com.selimsimsek.data.local.database.GithubDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRecipeDao(appDatabase: GithubDatabase): GithubDao {
        return appDatabase.githubDao()
    }


    @Provides
    @Singleton
    fun provideRecipeList(): Converter {
        return Converter()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context,
        converter: Converter,
    ): GithubDatabase {
        return Room.databaseBuilder(
            context,
            GithubDatabase::class.java,
            "github4.db"
        ).fallbackToDestructiveMigration()
            .addTypeConverter(converter)
            .build()
    }
}