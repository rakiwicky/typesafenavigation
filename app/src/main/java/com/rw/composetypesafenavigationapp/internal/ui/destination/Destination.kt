package com.rw.composetypesafenavigationapp.internal.ui.destination

import com.rw.composetypesafenavigationapp.internal.domain.Profile
import kotlinx.serialization.Serializable

internal sealed interface Destination {

    @Serializable
    data object HomeScreen : Destination

    @Serializable
    data class ListScreen(val key: String) : Destination

    @Serializable
    data class DetailScreen(val profile: Profile) : Destination
}