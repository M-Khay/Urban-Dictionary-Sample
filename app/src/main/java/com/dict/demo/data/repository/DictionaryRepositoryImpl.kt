package com.dict.demo.data.repository

import android.content.Context
import com.dict.demo.data.DictionaryApiServices
import com.dict.demo.domain.model.Dictionary
import io.reactivex.Single

class DictionaryRepositoryImpl(private val service: DictionaryApiServices,
                               private val context: Context) : NewsRepository {
    override fun getDictionaryTerm(term: String): Single<List<Dictionary>> {
        return service.getTopHeadlines(term)
                .flattenAsObservable { it.list }
                .map {
                    val article = Dictionary(
                            author = it.author,
                            currentVote = it.currentVote,
                            defid = it.defid,
                            definition = it.definition,
                            example = it.example,
                            permalink = it.permalink,
                            soundUrls = it.soundUrls,
                            thumbsDown = it.thumbsDown,
                            thumbsUp = it.thumbsUp,
                            word = it.word,
                            writtenOn = it.writtenOn
                    )
                    article
                }.toList()
    }
}