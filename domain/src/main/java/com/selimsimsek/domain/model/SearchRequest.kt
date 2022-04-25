package com.selimsimsek.domain.model

import com.google.gson.annotations.SerializedName

data class SearchRequest(
    @SerializedName("incomplete_results")
    var incompleteResults: Boolean,
    @SerializedName("items")
    var items: List<FollowersItem>,
    @SerializedName("total_count")
    var totalCount: Int
)