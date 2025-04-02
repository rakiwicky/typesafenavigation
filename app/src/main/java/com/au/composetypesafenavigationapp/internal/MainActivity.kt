package com.au.composetypesafenavigationapp.internal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.au.composetypesafenavigationapp.internal.domain.Profile
import com.au.composetypesafenavigationapp.internal.ui.destination.Destination
import com.au.composetypesafenavigationapp.internal.ui.detail.DetailScreen
import com.au.composetypesafenavigationapp.internal.ui.home.HomeScreen
import com.au.composetypesafenavigationapp.internal.ui.list.ListScreen
import com.au.feature_one.featureOneNavigationGraph
import com.au.feature_two.featureTwoNavigationGraph
import com.au.navigation.CustomNavType
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.typeOf

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()

            NavHost(
                navController = navHostController,
                startDestination = Destination.HomeScreen,
            ) {
                composable<Destination.HomeScreen> {
                    HomeScreen(navHostController)
                }

                composable<Destination.ListScreen> {
                    ListScreen(navHostController)
                }

                composable<Destination.DetailScreen>(
                    typeMap = mapOf(
                        typeOf<Profile>() to CustomNavType<Profile>(
                            Profile::class,
                            Profile.serializer()
                        )
                    )
                ) {
                    DetailScreen(navHostController)
                }


                featureOneNavigationGraph(navHostController, this@NavHost)
                featureTwoNavigationGraph(navHostController, this@NavHost)
            }
        }
    }
}