package com.dict.demo.data.model

import com.google.gson.annotations.SerializedName

data class DictionaryModel(
        @SerializedName("author")
        var author: String,
        @SerializedName("current_vote")
        var currentVote: String,
        @SerializedName("defid")
        var defid: Int,
        @SerializedName("definition")
        var definition: String,
        @SerializedName("example")
        var example: String,
        @SerializedName("permalink")
        var permalink: String,
        @SerializedName("sound_urls")
        var soundUrls: List<Any>,
        @SerializedName("thumbs_down")
        var thumbsDown: Int,
        @SerializedName("thumbs_up")
        var thumbsUp: Int,
        @SerializedName("word")
        var word: String,
        @SerializedName("written_on")
        var writtenOn: String
)