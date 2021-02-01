package com.muratguc.ingchallange.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.muratguc.ingchallange.common.SingleLiveEvent
import com.muratguc.ingchallange.data.datasourse.RepoListPagingDataSource
import com.muratguc.ingchallange.domain.usecase.RepoListUseCase

class RepoListViewModel @ViewModelInject constructor(
    private val repoListUseCase: RepoListUseCase
) :
    ViewModel() {
    var searchQuery = SingleLiveEvent<String>().apply { value = "abdullahmuratguc" }

    fun fetchRepos() = Pager(PagingConfig(pageSize = 20)) {
        RepoListPagingDataSource(repoListUseCase, searchQuery.value)
    }.flow.cachedIn(viewModelScope)
}