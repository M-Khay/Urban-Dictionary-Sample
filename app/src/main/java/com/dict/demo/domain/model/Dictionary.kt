package com.dict.demo.domain.model

import java.io.Serializable

data class Dictionary(
        var author: String,
        var currentVote: String,
        var defid: Int,
        var definition: String,
        var example: String,
        var permalink: String,
        var soundUrls: List<Any>,
        var thumbsDown: Int,
        var thumbsUp: Int,
        var word: String,
        var writtenOn: String

) : Serializable