package com.rw.composetypesafenavigationapp.internal.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
internal fun ListScreen(
    navigationController: NavController
) {
    val viewModel = hiltViewModel<ListViewModel>()
    Screen(viewModel)

    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner.lifecycle) {
        lifecycleOwner.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.navigationActions.collect { navigationAction ->
                navigationAction.performAction(navigationController)
            }
        }
    }
}

@Composable
private fun Screen(viewModel: ListViewModel) {
    Column(
        modifier = Modifier.padding(
            horizontal = 16.dp
        ).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val coroutineScope = rememberCoroutineScope()

        LazyColumn {
            items(
                items = viewModel.binding.items,
                key = { profile -> profile.key }
            ) { profile ->
                Card(
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClick = {
                                coroutineScope.launch {
                                    profile.itemOnClick()
                                }
                            }
                        )
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = profile.fullName
                    )
                }
            }
        }
    }
}