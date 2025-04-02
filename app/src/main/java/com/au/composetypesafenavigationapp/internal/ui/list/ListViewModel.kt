package com.au.composetypesafenavigationapp.internal.ui.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.au.composetypesafenavigationapp.internal.domain.Profile
import com.au.composetypesafenavigationapp.internal.ui.destination.Destination
import com.au.navigation.Navigate
import com.au.navigation.NavigationAction
import com.au.navigation.PopBackStack
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
internal class ListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    listItemMapper: ListItemMapper,
) : ViewModel() {

    private val profiles = listOf(
        Profile(
            id = 1,
            title = "Mr",
            name = "John",
            age = 13,
            gender = "M"
        ),
        Profile(
            id = 2,
            title = "Mr",
            name = "Charles",
            age = 33,
            gender = "M"
        ),
        Profile(
            id = 3,
            title = "Mrs",
            name = "Jenny",
            age = 40,
            gender = "F"
        ),
        Profile(
            id = 4,
            title = "Mr",
            name = "Sudu",
            age = 13,
            gender = "M"
        ),
        Profile(
            id = 5,
            title = "Mr",
            name = "Chooty",
            age = 33,
            gender = "M"
        ),
        Profile(
            id = 6,
            title = "Mrs",
            name = "Nilu",
            age = 40,
            gender = "F"
        ),
    )

    private val _navigationActions = Channel<NavigationAction>()
    val navigationActions: Flow<NavigationAction> = _navigationActions.receiveAsFlow()

    val binding = ListViewStateBinding(
        id = savedStateHandle.toRoute<Destination.ListScreen>().key,
        items = listItemMapper.create(
            items = profiles,
            onItemClicked = ::onItemClicked,
        )
    )

    suspend fun onContinueClicked() {
        _navigationActions.send(
            PopBackStack
        )
    }

    private suspend fun onItemClicked(profile: Profile) {
        _navigationActions.send(
            Navigate(Destination.DetailScreen(profile))
        )
    }
}