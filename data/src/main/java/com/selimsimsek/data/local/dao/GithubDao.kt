package com.selimsimsek.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.selimsimsek.data.local.local_dto.RepositoryItemDb

@Dao
interface GithubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepository(result: RepositoryItemDb): Long

    @Query("SELECT * FROM RepositoryItemDb")
    suspend fun getAllRepository(): List<RepositoryItemDb>

    @Query("DELETE FROM RepositoryItemDb WHERE id = :id")
    suspend fun deleteRepository(id: Int)

    @Query("SELECT EXISTS (SELECT 1 FROM RepositoryItemDb WHERE id = :id)")
    fun exists(id: Int): Boolean

}