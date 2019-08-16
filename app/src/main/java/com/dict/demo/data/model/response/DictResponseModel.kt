package com.dict.demo.data.model.response

import com.google.gson.annotations.SerializedName
import com.dict.demo.data.model.DictionaryModel

data class DictResponseModel(
        @SerializedName("list")
        var list: List<DictionaryModel>
)
