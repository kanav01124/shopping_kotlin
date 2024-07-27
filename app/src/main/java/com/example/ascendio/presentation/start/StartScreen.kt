package com.example.ascendio.presentation.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    onStartClick: () -> Unit
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Shopping") })
        }
    ) {innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                onStartClick()
            }
            ) {
                Text(text = "Start")
            }
        }
    }

}

@Preview
@Composable
fun StartScreenPreview() {
    StartScreen( {})
}
