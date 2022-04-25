package com.selimsimsek.data.local.local_dto

import com.google.gson.annotations.SerializedName

data class SearchRequestDb(
    @SerializedName("incomplete_results")
    var incompleteResults: Boolean,
    @SerializedName("items")
    var items: List<FollowerItemDb>,
    @SerializedName("total_count")
    var totalCount: Int
)