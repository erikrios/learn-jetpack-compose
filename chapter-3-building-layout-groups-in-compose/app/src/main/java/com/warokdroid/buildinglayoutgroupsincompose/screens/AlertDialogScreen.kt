package com.warokdroid.buildinglayoutgroupsincompose.screens

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.warokdroid.buildinglayoutgroupsincompose.R
import com.warokdroid.buildinglayoutgroupsincompose.router.BackButtonHandler
import com.warokdroid.buildinglayoutgroupsincompose.router.JetFundamentalsRouter
import com.warokdroid.buildinglayoutgroupsincompose.router.Screen

@Composable
fun AlertDialogScreen() {

    MyAlertDialog()

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
@Preview
fun MyAlertDialog() {
    val shouldShowDialog = remember {
        mutableStateOf(true)
    }

    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
                JetFundamentalsRouter.navigateTo(Screen.Navigation)
            },
            title = { Text(text = stringResource(id = R.string.alert_dialog_title)) },
            text = { Text(text = stringResource(id = R.string.alert_dialog_text)) },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.colorPrimary)),
                    onClick = {
                        shouldShowDialog.value = false
                        JetFundamentalsRouter.navigateTo(Screen.Navigation)
                    },
                ) {
                    Text(
                        text = stringResource(id = R.string.confirm),
                        color = Color.White
                    )
                }
            }
        )
    }
}