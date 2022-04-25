package com.selimsimsek.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.selimsimsek.data.local.converters.Converter
import com.selimsimsek.data.local.dao.GithubDao
import com.selimsimsek.data.local.local_dto.FollowerItemDb
import com.selimsimsek.data.local.local_dto.RepositoryItemDb
import com.selimsimsek.data.local.local_dto.UserModelDb

@TypeConverters(value = [Converter::class])
@Database(entities = [RepositoryItemDb::class, FollowerItemDb::class, UserModelDb::class], version = 2)
abstract class GithubDatabase : RoomDatabase() {

    abstract fun githubDao(): GithubDao
}