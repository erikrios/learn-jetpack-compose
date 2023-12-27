package com.warokdroid.jetnotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.warokdroid.jetnotes.ui.theme.green

@Composable
fun Note(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(green)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Title", maxLines = 1)
            Text(text = "Content", maxLines = 1)
        }
        Checkbox(
            checked = false,
            onCheckedChange = {},
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
private fun NotePreview() {
    Note()
}