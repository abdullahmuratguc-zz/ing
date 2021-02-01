package com.muratguc.ingchallange.data.datasourse

import androidx.paging.PagingSource
import com.muratguc.ingchallange.data.model.RepoListResponseModel
import com.muratguc.ingchallange.domain.usecase.RepoListUseCase
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Murat Güç on 2/1/2021.
 */
class RepoListPagingDataSource(
    private val useCase: RepoListUseCase,
    private val searchQuery: String?
) :
    PagingSource<Int, RepoListResponseModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepoListResponseModel> {
        return try {
            val position = params.key ?: 1
            val response = useCase.repoList(userName = searchQuery, position, params.loadSize)
            val list = response
            LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = if (list.isEmpty()) null else position.plus(1)
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}