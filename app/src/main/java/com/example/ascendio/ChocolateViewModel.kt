package com.example.ascendio

import androidx.lifecycle.ViewModel
import com.example.ascendio.data.Item
import com.example.ascendio.data.ShoppingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChocolateViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<ShoppingUiState>(ShoppingUiState())
    val uiState = _uiState.asStateFlow()

    fun addItem(item: Item) {
        _uiState.value.items.add(item)
    }

    fun removeItem(item: Item) {
        _uiState.value.items.remove(item)
    }

    fun calculatePrice(): Float {
        var sum = 0f

        _uiState.value.items.forEach {
            sum += it.price
        }

        return sum
    }

    fun reset() {
        _uiState.value = ShoppingUiState()
    }
}