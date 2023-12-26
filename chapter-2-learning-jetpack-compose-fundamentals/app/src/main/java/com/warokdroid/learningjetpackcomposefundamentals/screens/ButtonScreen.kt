package com.warokdroid.learningjetpackcomposefundamentals.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.warokdroid.learningjetpackcomposefundamentals.R
import com.warokdroid.learningjetpackcomposefundamentals.router.BackButtonHandler
import com.warokdroid.learningjetpackcomposefundamentals.router.JetFundamentalsRouter
import com.warokdroid.learningjetpackcomposefundamentals.router.Screen

@Composable
fun ExploreButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        MyButton()
        MyRadioGroup()
        MyFloatingActionButton()

        BackButtonHandler {
            JetFundamentalsRouter.navigateTo(Screen.Navigation)
        }
    }
}

@Composable
@Preview
fun MyButton() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.colorPrimary)),
        border = BorderStroke(
            1.dp,
            color = colorResource(id = R.color.colorPrimaryDark)
        )
    ) {
        Text(
            text = stringResource(id = R.string.button_text),
            color = Color.White
        )
    }
}

@Composable
@Preview
fun MyRadioGroup() {
    val radioButtons = listOf(0, 1, 2)
    val selectedButton = remember {
        mutableIntStateOf(radioButtons.first())
    }

    Column {
        radioButtons.forEach { index ->
            val isSelected = index == selectedButton.intValue
            val colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(id = R.color.colorPrimary),
                unselectedColor = colorResource(id = R.color.colorPrimaryDark),
                disabledSelectedColor = Color.LightGray
            )

            RadioButton(
                colors = colors,
                selected = isSelected,
                onClick = { selectedButton.intValue = index }
            )
        }
    }
}

@Composable
@Preview
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        containerColor = colorResource(id = R.color.colorPrimary),
        contentColor = Color.White,
    ) {
        Icon(Icons.Filled.Favorite, contentDescription = "Test")
    }
}
