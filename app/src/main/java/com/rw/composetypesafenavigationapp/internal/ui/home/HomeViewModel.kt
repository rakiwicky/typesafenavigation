package com.rw.composetypesafenavigationapp.internal.ui.home

import androidx.lifecycle.ViewModel
import com.rw.composetypesafenavigationapp.internal.ui.destination.Destination
import com.rw.feature_one.internal.destination.FeatureOneDestination
import com.rw.feature_two.FeatureTwoSubGraph
import com.rw.navigation.Navigate
import com.rw.navigation.NavigationAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
) : ViewModel() {

    private val _navigationActions = Channel<NavigationAction>()
    val navigationActions: Flow<NavigationAction> = _navigationActions.receiveAsFlow()

    suspend fun onContinueClicked() {
        _navigationActions.send(
            Navigate(Destination.ListScreen("1"))
        )
    }

    suspend fun onFeatureOneContinueClicked() {
        _navigationActions.send(
            Navigate(FeatureOneDestination.FeatureOneHomeScreen)
        )
    }

    suspend fun onFeatureTwoContinueClicked() {
        _navigationActions.send(
            Navigate(FeatureTwoSubGraph)
        )
    }
}