package com.warokdroid.jetfundamentals.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.warokdroid.jetfundamentals.R
import com.warokdroid.jetfundamentals.router.BackButtonHandler
import com.warokdroid.jetfundamentals.router.JetFundamentalsRouter
import com.warokdroid.jetfundamentals.router.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScaffoldScreen() {
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = { MyColumn() },
        drawerState = drawerState,
    ) {
        MyScaffold(drawerState)
    }

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyScaffold(drawerState: DrawerState) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        contentColor = colorResource(id = R.color.colorPrimary),
        content = { padding ->
            MyRow(modifier = Modifier.padding(padding))
        },
        topBar = { MyTopAppBar(drawerState = drawerState, scope = scope) },
        bottomBar = { MyBottomAppBar() },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(drawerState: DrawerState, scope: CoroutineScope) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = colorResource(id = R.color.colorPrimary)),
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        if (drawerState.isClosed) {
                            drawerState.open()
                        } else {
                            drawerState.close()
                        }
                    }
                },
            ) {
                Icon(
                    Icons.Default.Menu,
                    tint = Color.White,
                    contentDescription = stringResource(id = R.string.menu)
                )
            }
        }
    )
}

@Composable
fun MyBottomAppBar() {
    BottomAppBar(containerColor = colorResource(id = R.color.colorPrimary)) {}
}

