package com.au.composetypesafenavigationapp.internal.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.au.composetypesafenavigationapp.internal.domain.Profile
import com.au.composetypesafenavigationapp.internal.ui.destination.Destination
import com.au.navigation.CustomNavType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.reflect.typeOf

@HiltViewModel
internal class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val profile = savedStateHandle.toRoute<Destination.DetailScreen>(
        typeMap = mapOf(
            typeOf<Profile>() to CustomNavType<Profile>(
                Profile::class,
                Profile.serializer()
            )
        )
    ).profile
}