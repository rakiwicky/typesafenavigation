package com.rw.composetypesafenavigationapp.internal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rw.composetypesafenavigationapp.internal.domain.Profile
import com.rw.composetypesafenavigationapp.internal.ui.destination.Destination
import com.rw.composetypesafenavigationapp.internal.ui.detail.DetailScreen
import com.rw.composetypesafenavigationapp.internal.ui.home.HomeScreen
import com.rw.composetypesafenavigationapp.internal.ui.list.ListScreen
import com.rw.feature_one.featureOneNavigationGraph
import com.rw.feature_two.featureTwoNavigationGraph
import com.rw.navigation.CustomNavType
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