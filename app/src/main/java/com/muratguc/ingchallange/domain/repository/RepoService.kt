package com.muratguc.ingchallange.domain.repository

import com.muratguc.ingchallange.data.model.RepoListResponseModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Murat Güç on 2/1/2021.
 */
interface RepoService {

    //@Headers("Authorization: token "Token ekle"")
    @GET("/users/{user_name}/repos")
    suspend fun getUserRepos(
        @Path("user_name") userName: String?,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int,
    ): List<RepoListResponseModel>
}