package com.warokdroid.jetfundamentals.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.warokdroid.jetfundamentals.router.BackButtonHandler
import com.warokdroid.jetfundamentals.router.JetFundamentalsRouter
import com.warokdroid.jetfundamentals.router.Screen

@Composable
fun ColumnScreen() {
    MyColumn()

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
@Preview
fun MyColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        THREE_ELEMENT_LIST.forEach { textResId ->
            Text(
                text = stringResource(id = textResId),
                fontSize = 22.sp
            )
        }
    }
}