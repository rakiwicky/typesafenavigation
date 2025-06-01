package com.rw.feature_two

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rw.feature_two.internal.destination.FeatureTwoDestination
import com.rw.feature_two.internal.ui.FeatureTwoHomeScreen
import kotlinx.serialization.Serializable

fun featureTwoNavigationGraph(
    navigationController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.navigation<FeatureTwoSubGraph>(
        startDestination = FeatureTwoDestination.FeatureTwoHomeScreen
    ) {
        composable<FeatureTwoDestination.FeatureTwoHomeScreen> {
            FeatureTwoHomeScreen(navigationController)
        }
    }
}


@Serializable
data object FeatureTwoSubGraph