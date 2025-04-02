package com.au.feature_two.internal.destination

import kotlinx.serialization.Serializable

internal sealed interface FeatureTwoDestination {

    @Serializable
    data object FeatureTwoHomeScreen : FeatureTwoDestination
}