package com.warokdroid.learningjetpackcomposefundamentals.app

import androidx.compose.animation.Crossfade
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.warokdroid.learningjetpackcomposefundamentals.router.JetFundamentalsRouter
import com.warokdroid.learningjetpackcomposefundamentals.router.Screen
import com.warokdroid.learningjetpackcomposefundamentals.screens.AlertDialogScreen
import com.warokdroid.learningjetpackcomposefundamentals.screens.ProgressIndicatorScreen
import com.warokdroid.learningjetpackcomposefundamentals.screens.ExploreButtonsScreen
import com.warokdroid.learningjetpackcomposefundamentals.screens.NavigationScreen
import com.warokdroid.learningjetpackcomposefundamentals.screens.TextFieldScreen
import com.warokdroid.learningjetpackcomposefundamentals.screens.TextScreen

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
            }
        }
    }
}