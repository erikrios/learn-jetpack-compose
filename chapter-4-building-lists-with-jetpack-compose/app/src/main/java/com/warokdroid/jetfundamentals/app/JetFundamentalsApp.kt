package com.warokdroid.jetfundamentals.app

import androidx.compose.animation.Crossfade
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.warokdroid.jetfundamentals.router.JetFundamentalsRouter
import com.warokdroid.jetfundamentals.router.Screen
import com.warokdroid.jetfundamentals.screens.AlertDialogScreen
import com.warokdroid.jetfundamentals.screens.BoxScreen
import com.warokdroid.jetfundamentals.screens.ColumnScreen
import com.warokdroid.jetfundamentals.screens.ExploreButtonsScreen
import com.warokdroid.jetfundamentals.screens.GridScreen
import com.warokdroid.jetfundamentals.screens.ListScreen
import com.warokdroid.jetfundamentals.screens.NavigationScreen
import com.warokdroid.jetfundamentals.screens.ProgressIndicatorScreen
import com.warokdroid.jetfundamentals.screens.RowScreen
import com.warokdroid.jetfundamentals.screens.ScaffoldScreen
import com.warokdroid.jetfundamentals.screens.ScrollingScreen
import com.warokdroid.jetfundamentals.screens.SurfaceScreen
import com.warokdroid.jetfundamentals.screens.TextFieldScreen
import com.warokdroid.jetfundamentals.screens.TextScreen

@Composable
fun JetFundamentalsApp() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Crossfade(targetState = JetFundamentalsRouter.currentScreen, label = "") { screenState ->
            when (screenState.value) {
                is Screen.Navigation -> NavigationScreen()
                is Screen.Text -> TextScreen()
                is Screen.TextField -> TextFieldScreen()
                is Screen.Buttons -> ExploreButtonsScreen()
                is Screen.ProgressIndicator -> ProgressIndicatorScreen()
                is Screen.AlertDialog -> AlertDialogScreen()
                is Screen.Row -> RowScreen()
                is Screen.Column -> ColumnScreen()
                is Screen.Box -> BoxScreen()
                is Screen.Surface -> SurfaceScreen()
                is Screen.Scaffold -> ScaffoldScreen()
                is Screen.Scrolling -> ScrollingScreen()
                is Screen.List -> ListScreen()
                is Screen.Grid -> GridScreen()
            }
        }
    }
}