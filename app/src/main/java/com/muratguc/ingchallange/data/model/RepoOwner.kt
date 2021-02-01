package com.muratguc.ingchallange.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Murat Güç on 2/1/2021.
 */
@Parcelize
data class RepoOwner(
    val login: String,
    val avatar_url: String
): Parcelable