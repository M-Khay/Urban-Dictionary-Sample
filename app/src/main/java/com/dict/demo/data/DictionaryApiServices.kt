package com.dict.demo.data

import com.dict.demo.data.model.response.DictResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DictionaryApiServices {
    @GET("define")
    fun getTopHeadlines(@Query("term") term: String): Single<DictResponseModel>
}