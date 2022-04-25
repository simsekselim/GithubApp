package com.selimsimsek.data.remote.remote_dto

import com.google.gson.annotations.SerializedName
import com.selimsimsek.domain.model.FollowersItem

data class SearchRequestResponse(
    @SerializedName("incomplete_results")
    var incompleteResults: Boolean,
    @SerializedName("items")
    var items: List<FollowerItemResponse>,
    @SerializedName("total_count")
    var totalCount: Int
)