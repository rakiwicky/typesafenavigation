package com.au.composetypesafenavigationapp.internal.ui.home

import androidx.lifecycle.ViewModel
import com.au.composetypesafenavigationapp.internal.ui.destination.Destination
import com.au.feature_one.FeatureOneSubGraph
import com.au.feature_one.internal.destination.FeatureOneDestination
import com.au.feature_two.FeatureTwoSubGraph
import com.au.navigation.Navigate
import com.au.navigation.NavigationAction
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