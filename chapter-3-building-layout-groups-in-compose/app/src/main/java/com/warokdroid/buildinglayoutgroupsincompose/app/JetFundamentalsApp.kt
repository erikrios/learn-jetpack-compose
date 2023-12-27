package com.warokdroid.buildinglayoutgroupsincompose.app

import androidx.compose.animation.Crossfade
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.warokdroid.buildinglayoutgroupsincompose.router.JetFundamentalsRouter
import com.warokdroid.buildinglayoutgroupsincompose.router.Screen
import com.warokdroid.buildinglayoutgroupsincompose.screens.AlertDialogScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.BoxScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.ColumnScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.ExploreButtonsScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.NavigationScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.ProgressIndicatorScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.RowScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.ScaffoldScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.SurfaceScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.TextFieldScreen
import com.warokdroid.buildinglayoutgroupsincompose.screens.TextScreen

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
            }
        }
    }
}