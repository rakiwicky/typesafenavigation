package com.au.composetypesafenavigationapp.internal.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    navigationController: NavController
) {
    val viewModel = hiltViewModel<HomeViewModel>()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                title = {
                    Text(
                        text = "Home Screen"
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val coroutineScope = rememberCoroutineScope()

            Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.onContinueClicked()
                    }
                }
            ) {
                Text(
                    text = "List Screen"
                )
            }

            Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.onFeatureOneContinueClicked()
                    }
                }
            ) {
                Text(
                    text = "Navigation to Feature 1 - Home Screen"
                )
            }

            Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.onFeatureTwoContinueClicked()
                    }
                }
            ) {
                Text(
                    text = "Navigation to Feature 2 - Home Screen"
                )
            }
        }

        LaunchedEffect(Unit) {
            viewModel.navigationActions.collect { navigationAction ->
                navigationAction.performAction(navigationController)
            }
        }
    }
}