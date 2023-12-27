package com.warokdroid.buildinglayoutgroupsincompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.warokdroid.buildinglayoutgroupsincompose.R
import com.warokdroid.buildinglayoutgroupsincompose.router.BackButtonHandler
import com.warokdroid.buildinglayoutgroupsincompose.router.JetFundamentalsRouter
import com.warokdroid.buildinglayoutgroupsincompose.router.Screen

@Composable
fun SurfaceScreen(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize()) {
        MySurface(modifier = modifier.align(Alignment.Center))
    }

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MySurface(modifier: Modifier) {
    Surface(
        modifier = modifier.size(100.dp),
        color = Color.LightGray,
        contentColor = colorResource(id = R.color.colorPrimary),
        shadowElevation = 1.dp,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        MyColumn()
    }
}