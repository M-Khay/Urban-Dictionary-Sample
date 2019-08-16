package com.dict.demo.ui.home

import com.dict.demo.ui.dictionary.NewsListFragmentModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [NewsListFragmentModule::class])
interface HomeActivitySubcomponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}