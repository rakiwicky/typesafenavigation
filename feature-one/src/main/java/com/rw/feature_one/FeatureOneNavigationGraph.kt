package com.rw.feature_one

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rw.feature_one.internal.destination.FeatureOneDestination
import com.rw.feature_one.internal.ui.FeatureOneHomeScreen
import kotlinx.serialization.Serializable


fun featureOneNavigationGraph(
    navigationController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.navigation<FeatureOneSubGraph>(
        startDestination = FeatureOneDestination.FeatureOneHomeScreen
    ) {
        composable<FeatureOneDestination.FeatureOneHomeScreen> {
            FeatureOneHomeScreen(navigationController)
        }
    }
}

@Serializable
data object FeatureOneSubGraph