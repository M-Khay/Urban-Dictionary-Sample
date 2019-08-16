package com.dict.demo.ui.dictionary

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dict.demo.R
import com.dict.demo.ui.dictionary.rvitem.DictionaryRowItem
import com.task.utils.AppConstants
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.dictionary_list_fragment.*
import javax.inject.Inject

private val TAG = DictionaryListFragment::class.java.name

class DictionaryListFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: NewsListViewModel
    private val groupAdapter = GroupAdapter<ViewHolder>()
    private var isLoading = false

    companion object {
        fun newInstance() = DictionaryListFragment()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dictionary_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsListViewModel::class.java)

        setupRv()
        loading.setOnRefreshListener(this)

        observerViewModel()

        search_go.setOnClickListener {
            val enteredString = text.text.toString().trim()
            if (!TextUtils.isEmpty(enteredString)) {
                AppConstants.term = enteredString
                onRefresh()
            } else {
                Toast.makeText(activity, getString(R.string.enter_text_search), Toast.LENGTH_SHORT).show()
            }
        }
        savedInstanceState?.let {
            viewModel.restoreNewsList()
        } ?: viewModel.updateNewsList()
    }

    private fun setupRv() {
        rvNews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = groupAdapter
        }
    }

    private fun observerViewModel() {
        viewModel.stateLiveData.observe(this, newsStateObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.stateLiveData.removeObserver(newsStateObserver)
    }

    override fun onRefresh() {
        groupAdapter.clear()
        viewModel.refreshNewsList()
    }

    // state observer
    private val newsStateObserver = Observer<DictionaryListState> { state ->
        state?.let {
            when (state) {
                is DefaultState -> {
                    isLoading = false
                    loading.isRefreshing = false
                    // add data to adapter
                    it.data.map {
                        Section().apply {
                            add(DictionaryRowItem(it))
                            groupAdapter.add(this)
                        }
                    }
                }
                is LoadingState -> {
                    Log.d(TAG, "loading state")
                    loading.isRefreshing = true
                    isLoading = true
                }

                is ErrorState -> {
                    Log.e(TAG, "error state")
                    Toast.makeText(activity, "Error from api side", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
