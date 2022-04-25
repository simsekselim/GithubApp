package com.selimsimsek.data.remote.service

import com.selimsimsek.data.remote.remote_dto.FollowerItemResponse
import com.selimsimsek.data.remote.remote_dto.RepositoryItemResponse
import com.selimsimsek.data.remote.remote_dto.SearchRequestResponse
import com.selimsimsek.data.remote.remote_dto.UserModelResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {


    @GET("/users/{username}")
    suspend fun detailUser(
        @Path("username") username: String
    ): UserModelResponse


    @GET("/users/{username}/followers")
    suspend fun userFollowers(
        @Path("username") username: String
    ): List<FollowerItemResponse>

    @GET("/users/{username}/following")
    suspend fun userFollowing(
        @Path("username") username: String
    ): List<FollowerItemResponse>

    @GET("/users/{username}/repos")
    suspend fun userRepo(
        @Path("username") username: String
    ): List<RepositoryItemResponse>


    @GET("/search/users")
    suspend fun searchUser(
        @Query("q") username: String?
    ): SearchRequestResponse

}