package com.selimsimsek.data.repository

import androidx.lifecycle.MutableLiveData
import com.selimsimsek.data.mapper.toDomainModel
import com.selimsimsek.data.remote.service.APIService
import com.selimsimsek.domain.model.FollowersItem
import com.selimsimsek.domain.model.RepositoryItem
import com.selimsimsek.domain.model.SearchRequest
import com.selimsimsek.domain.model.UserModel
import com.selimsimsek.domain.repository.GithubRepository
import javax.inject.Inject

class DefaultGithubRepository @Inject constructor(
    private val service: APIService,
) : GithubRepository, BaseRepository() {
    override suspend fun detailUser(username: String): UserModel =
        execute {
            service.detailUser(username).toDomainModel()
        }

    override suspend fun userFollowers(username: String): List<FollowersItem> {
        TODO("Not yet implemented")
    }

    override suspend fun userFollowing(username: String): List<FollowersItem> {
        TODO("Not yet implemented")
    }

    override suspend fun userRepo(username: String): List<RepositoryItem> =
        execute {
            service.userRepo(username).map {
                it.toDomainModel()
            }
        }


    override suspend fun searchUser(username: String?): SearchRequest =
        execute {
            service.searchUser(username).toDomainModel()
        }

}