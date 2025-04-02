package com.au.feature_one.internal.destination

import kotlinx.serialization.Serializable

sealed interface FeatureOneDestination {

    @Serializable
    data object FeatureOneHomeScreen : FeatureOneDestination
}