package com.example.ascendio.presentation.chocolates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ascendio.ChocolateViewModel
import com.example.ascendio.data.Chocolates
import com.example.ascendio.data.Item
import com.example.ascendio.data.ShoppingUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChocolateScreen(
    chocolateViewModel: ChocolateViewModel,
    onNextClick: () -> Unit,
    onCancelClick: () -> Unit

) {


    val uiState by chocolateViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Chocolate")
            })
        }
    ) {

        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            Chocolates.chocolateList.forEach {eachItem ->
                ChocolateItem(uiState = uiState, addItem = {item ->
                    chocolateViewModel.addItem(item)
                }, removeItem = {item ->
                    chocolateViewModel.removeItem(item)
                }, chocolate = eachItem)
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)) {
                OutlinedButton(onClick = {
                    onCancelClick()
                },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)) {
                    Text(text = "Cancel")
                }
                Button(onClick = { onNextClick() },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)) {
                    Text(text = "Next")
                }
            }
        }
    }

}

@Composable
fun ChocolateItem(
    uiState: ShoppingUiState,
    addItem: (Item) -> Unit,
    removeItem: (Item) -> Unit,
    chocolate: Item
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = uiState.items.contains(chocolate),
            onCheckedChange = {
                if (it) {
                    addItem(chocolate)
                }
                else {
                    removeItem(chocolate)
                }
            },
            modifier = Modifier.padding(4.dp)
        )

        Text(text = chocolate.name,
            modifier = Modifier.padding(4.dp))

        Spacer(modifier = Modifier.weight(1f))

        Text(text = chocolate.price.toString(),
            modifier = Modifier.padding(12.dp))
    }
}