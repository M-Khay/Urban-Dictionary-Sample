package com.dict.demo.ui.dictionary

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Subcomponent
interface NewsListFragmentSubcomponent : AndroidInjector<DictionaryListFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DictionaryListFragment>()
}

@Module(subcomponents = [NewsListFragmentSubcomponent::class])
abstract class NewsListFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(DictionaryListFragment::class)
    abstract fun bindCryptoListFragmentInjectorFactory(builder: NewsListFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>
}