package com.selimsimsek.domain.repository

import com.selimsimsek.domain.model.FollowersItem
import com.selimsimsek.domain.model.RepositoryItem
import com.selimsimsek.domain.model.SearchRequest
import com.selimsimsek.domain.model.UserModel

interface GithubRepository {
    suspend fun detailUser(username: String) : UserModel
    suspend fun userFollowers(username: String): List<FollowersItem>
    suspend fun userFollowing(username: String): List<FollowersItem>
    suspend fun userRepo(username: String): List<RepositoryItem>
    suspend fun searchUser(username: String?): SearchRequest
}