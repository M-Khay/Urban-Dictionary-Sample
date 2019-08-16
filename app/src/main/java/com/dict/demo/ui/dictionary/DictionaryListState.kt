package com.dict.demo.ui.dictionary

import com.dict.demo.domain.model.Dictionary

sealed class DictionaryListState {
    abstract val data: List<Dictionary>
    abstract val loadedAllItems: Boolean
}

data class DefaultState(override val data: List<Dictionary>, override val loadedAllItems: Boolean) : DictionaryListState()
data class LoadingState(override val data: List<Dictionary>, override val loadedAllItems: Boolean) : DictionaryListState()
data class ErrorState(val errorMessage: String, override val data: List<Dictionary>, override val loadedAllItems: Boolean) : DictionaryListState()