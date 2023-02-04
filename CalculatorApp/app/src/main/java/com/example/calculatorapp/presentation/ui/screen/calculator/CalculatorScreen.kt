package com.example.calculatorapp.presentation.ui.screen.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calculatorapp.presentation.model.calculatorUiActions
import com.example.calculatorapp.presentation.ui.component.CalculatorButtonGrid
import com.example.calculatorapp.presentation.ui.component.CalculatorDisplay

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel
) {
    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CalculatorDisplay(
            expression = state.expression,
            modifier = Modifier.weight(1f)
        )

        CalculatorButtonGrid(
            listOfButtons = calculatorUiActions,
            onClick = {
                viewModel.onAction(it.action)
            }
        )
    }
}