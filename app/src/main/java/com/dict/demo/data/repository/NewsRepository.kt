package com.dict.demo.data.repository

import com.dict.demo.domain.model.Dictionary
import io.reactivex.Single

interface NewsRepository {
    fun getDictionaryTerm(term: String): Single<List<Dictionary>>
}