package com.muratguc.ingchallange.domain.usecase

import com.muratguc.ingchallange.data.model.RepoListResponseModel
import com.muratguc.ingchallange.domain.repository.RepoService
import javax.inject.Inject

/**
 * Created by Murat Güç on 2/1/2021.
 */
class RepoListUseCase @Inject constructor(
    private val repoService: RepoService
) {
    suspend fun repoList(userName: String?, page: Int, pageSize: Int): List<RepoListResponseModel> {
        return repoService.getUserRepos(userName, page, pageSize)
    }

}