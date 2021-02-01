package com.muratguc.ingchallange.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Murat Güç on 2/1/2021.
 */
@Parcelize
data class RepoListResponseModel(
    val id: Int,
    val name: String,
    val owner: RepoOwner,
    val open_issues_count: Int,
    val stargazers_count: Int
): Parcelable
