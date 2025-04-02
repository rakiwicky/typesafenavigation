package com.au.composetypesafenavigationapp.internal.ui.list

import com.au.composetypesafenavigationapp.internal.domain.Profile
import javax.inject.Inject

internal class ListItemMapper @Inject constructor() {

    fun create(
        items: List<Profile>,
        onItemClicked: suspend (Profile) -> Unit,
    ): List<ProfileListItem> {
        return buildList {
            items.map { profile ->
                add(
                    ProfileListItem(
                        key = profile.id.toString(),
                        fullName = profile.title + " " + profile.name,
                        itemOnClick = { onItemClicked(profile) }
                    )
                )
            }
        }
    }
}