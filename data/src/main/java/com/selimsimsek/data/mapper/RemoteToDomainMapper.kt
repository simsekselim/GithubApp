package com.selimsimsek.data.mapper

import com.selimsimsek.data.remote.remote_dto.*
import com.selimsimsek.domain.model.*

fun SearchRequestResponse.toDomainModel(): SearchRequest =
    SearchRequest(
        incompleteResults = this.incompleteResults,
        items = this.items.map {
            it.toDomainModel()
        },
        totalCount = this.totalCount

    )

fun FollowerItemResponse.toDomainModel(): FollowersItem =
    FollowersItem(
        avatarUrl = this.avatarUrl,
        eventsUrl = this.eventsUrl,
        followersUrl = this.followersUrl,
        followingUrl = this.followingUrl,
        gravatarId = this.gravatarId,
        htmlUrl = this.htmlUrl,
        id = this.id,
        login = this.login,
        nodeId = this.nodeId,
        organizationsUrl = this.organizationsUrl,
        receivedEventsUrl = this.receivedEventsUrl,
        reposUrl = this.reposUrl,
        siteAdmin = this.siteAdmin,
        starredUrl = this.starredUrl,
        subscriptionsUrl = this.subscriptionsUrl,
        type = this.type,
        gistsUrl = this.gistsUrl,
        url = this.url
    )

fun UserModelResponse.toDomainModel(): UserModel =
    UserModel(
        avatarUrl = this.avatarUrl,
        bio = this.bio,
        blog = this.blog,
        company = this.company,
        createdAt = this.createdAt,
        email = this.email,
        eventsUrl = this.eventsUrl,
        followers = this.followers,
        followersUrl = this.followersUrl,
        gistsUrl = this.gistsUrl,
        gravatarId = this.gravatarId,
        hireable = this.hireable,
        htmlUrl = this.htmlUrl,
        id = this.id,
        location = this.location,
        login = this.login,
        name = this.name,
        organizationsUrl = this.organizationsUrl,
        publicGists = this.publicGists,
        publicRepos = this.publicRepos,
        receivedEventsUrl = this.receivedEventsUrl,
        reposUrl = this.reposUrl,
        siteAdmin = this.siteAdmin,
        starredUrl = this.starredUrl,
        subscriptionsUrl = this.subscriptionsUrl,
        twitterUsername = this.twitterUsername,
        type = this.type,
        updatedAt = this.updatedAt,
        following = this.following,
        followingUrl = this.followingUrl,
        nodeId = this.nodeId,
        url = this.url,
        message = this.message
    )

fun RepositoryItemResponse.toDomainModel(): RepositoryItem =
    RepositoryItem(
        id = this.id,
        name = this.name,
        nodeId = this.nodeId,
        owner = this.owner?.toDomainModel(),
        url = this.url,
        fullName = this.fullName,
        description = this.description,
        stargazersCount = this.stargazersCount,
        openIssuesCount = this.openIssuesCount,
        language = this.language,
        forksCount = this.forksCount,
        htmlUrl = this.htmlUrl
    )

fun OwnerResponse.toDomainModel(): Owner =
    Owner(
        avatarUrl = this.avatarUrl,
        eventsUrl = this.eventsUrl,
        followersUrl = this.followersUrl,
        followingUrl = this.followingUrl,
        gistsUrl = this.gistsUrl,
        gravatarId = this.gravatarId,
        htmlUrl = this.htmlUrl,
        id = this.id,
        login = this.login,
        nodeId = this.nodeId,
        organizationsUrl = this.organizationsUrl,
        receivedEventsUrl = this.receivedEventsUrl,
        reposUrl = this.reposUrl,
        siteAdmin = this.siteAdmin,
        starredUrl = this.starredUrl,
        subscriptionsUrl = this.subscriptionsUrl,
        type = this.type,
        url = this.url,


    )