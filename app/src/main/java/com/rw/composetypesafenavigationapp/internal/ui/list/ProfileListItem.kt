package com.rw.composetypesafenavigationapp.internal.ui.list

internal data class ProfileListItem(
    val key: String,
    val fullName: String,
    val itemOnClick: suspend () -> Unit,
)