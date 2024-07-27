package com.example.ascendio.presentation.bill

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ascendio.ChocolateViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BillScreen(
    billViewModel: ChocolateViewModel,
    onClick: () -> Unit
) {
    
    val uiState by billViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Bill")
            })
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            uiState.items.forEach {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = it.name,
                        modifier = Modifier.padding(8.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = it.price.toString(),
                        modifier = Modifier.padding(8.dp))
                }
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Text(
                    text = "Total",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(text = billViewModel.calculatePrice().toString(),
                    modifier = Modifier.padding(8.dp))
            }

            Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                OutlinedButton(onClick = onClick,
                    modifier = Modifier.weight(1f).padding(4.dp)) {
                    Text(text = "Cancel")
                }
                Button(onClick = onClick,
                    modifier = Modifier.weight(1f).padding(4.dp)) {
                    Text(text = "Submit")

                }
            }
        }
    }
    

    
    
}