package com.warokdroid.buildinglayoutgroupsincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.warokdroid.buildinglayoutgroupsincompose.ui.theme.BuildingLayoutGroupsInComposeTheme
import com.warokdroid.buildinglayoutgroupsincompose.app.JetFundamentalsApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildingLayoutGroupsInComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetFundamentalsApp()
                }
            }
        }
    }
}