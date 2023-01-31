package com.example.calculatorapp.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.presentation.model.CalculatorUiAction
import com.example.calculatorapp.presentation.model.calculatorUiActions

@Composable
fun ButtonGrid(
    listOfButtons: List<CalculatorUiAction>,
    onClick: (CalculatorUiAction) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(listOfButtons.size) {
            CalculatorButton(
                uiAction = listOfButtons[it],
                modifier = Modifier.aspectRatio(1f),
                onClick = { onClick(listOfButtons[it]) }
            )
        }
    }
}

@Preview
@Composable
fun ButtonGridPreview() {
    ButtonGrid(listOfButtons = calculatorUiActions) {

    }
}