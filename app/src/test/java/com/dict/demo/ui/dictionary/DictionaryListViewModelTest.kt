package com.dict.demo.ui.dictionary


import org.junit.Rule
import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import org.mockito.Mock
import android.arch.lifecycle.LifecycleRegistry
import com.dict.demo.data.DictionaryApiServices
import com.dict.demo.data.repository.NewsRepository
import com.task.utils.AppConstants
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.mockito.MockitoAnnotations
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.Mockito.`when`


class DictionaryListViewModelTest {
    @Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    var apiEndPoint: DictionaryApiServices? = null
    @Mock
    var apiClient: NewsRepository? = null
    private var viewModel: NewsListViewModel? = null
    @Mock
    var observer: Observer<DictionaryListState>? = null
    @Mock
    var lifecycleOwner: LifecycleOwner? = null
    var lifecycle: Lifecycle? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        lifecycle = LifecycleRegistry(lifecycleOwner!!)
        viewModel = NewsListViewModel(apiClient)
        viewModel!!.stateLiveData.observeForever(observer!!)
    }

    @Test
    fun testNull() {
        `when`(apiClient?.getDictionaryTerm(term = AppConstants.term))
                .thenReturn(null)
        assertNotNull(viewModel?.stateLiveData)
        viewModel?.stateLiveData?.hasObservers()?.let { assertTrue(it) }
    }

    @Test
    fun testApiFetchDataSuccess() {
        // Mock API response
        `when`(apiClient?.getDictionaryTerm(term = AppConstants.term))
        viewModel?.getNewsList()

        verify(observer)?.onChanged(LoadingState(emptyList(), false))
        verify(observer)?.onChanged(DefaultState(emptyList(), false))

    }

    @Test
    fun testApiFetchDataError() {
        `when`(apiClient?.getDictionaryTerm(term = AppConstants.term))
        viewModel?.getNewsList()
        verify(observer)?.onChanged(LoadingState(emptyList(), false))
        verify(observer)?.onChanged(ErrorState("Error", emptyList(), false))
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        apiClient = null
        viewModel = null
    }
}

