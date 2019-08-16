package com.dict.demo.di

import android.content.Context
import com.dict.demo.data.DictionaryApiServices
import com.dict.demo.data.repository.NewsRepository
import com.dict.demo.data.repository.DictionaryRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNewsRepo(dictionaryApiServices: DictionaryApiServices, context: Context): NewsRepository = DictionaryRepositoryImpl(dictionaryApiServices, context)
}