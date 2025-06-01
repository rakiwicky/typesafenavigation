package com.rw.composetypesafenavigationapp.internal.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
internal data class Profile(
    val id: Int,
    val title: String,
    val name: String,
    val age: Int,
    val gender: String,
) : Parcelable