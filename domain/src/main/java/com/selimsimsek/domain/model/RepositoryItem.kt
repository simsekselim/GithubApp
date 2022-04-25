package com.selimsimsek.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class RepositoryItem constructor(
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("node_id")
    var nodeId: String? = null,
    @SerializedName("owner")
    var owner: Owner? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("full_name")
    var fullName: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("stargazers_count")
    var stargazersCount: Int? = null,
    @SerializedName("open_issues_count")
    var openIssuesCount: Int? = null,
    @SerializedName("language")
    var language: String? = null,
    @SerializedName("forks_count")
    var forksCount: Int? = null,
    @SerializedName("html_url")
    var htmlUrl: String? = null,
)




