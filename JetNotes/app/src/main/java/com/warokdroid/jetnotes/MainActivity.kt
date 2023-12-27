package com.warokdroid.jetnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.warokdroid.jetnotes.routing.Screen
import com.warokdroid.jetnotes.ui.components.AppDrawer
import com.warokdroid.jetnotes.ui.components.Note
import com.warokdroid.jetnotes.ui.theme.JetNotesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val coroutineScope = rememberCoroutineScope()
                    val drawerState: DrawerState =
                        rememberDrawerState(initialValue = DrawerValue.Closed)
                    ModalNavigationDrawer(
                        drawerContent = {
                            AppDrawer(
                                currentScreen = Screen.Notes,
                                onScreenSelected = { screen ->
                                    /* TODO */
                                    coroutineScope.launch {
                                        drawerState.close()
                                    }
                                }
                            )
                        },
                        drawerState = drawerState,
                    ) {
                        Scaffold { padding ->
                            Note(modifier = Modifier.padding(padding))
                        }
                    }

                }
            }
        }
    }
}
