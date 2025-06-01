package com.rw.composetypesafenavigationapp.internal.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.rw.composetypesafenavigationapp.internal.domain.Profile
import com.rw.composetypesafenavigationapp.internal.ui.destination.Destination
import com.rw.navigation.CustomNavType
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