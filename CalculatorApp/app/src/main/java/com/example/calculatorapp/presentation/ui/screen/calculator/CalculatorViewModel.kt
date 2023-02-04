package com.example.calculatorapp.presentation.ui.screen.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.calculatorapp.domain.CalculatorAction
import com.example.calculatorapp.domain.ExpressionWriter

class CalculatorViewModel {

    private val expressionWriter = ExpressionWriter()

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        expressionWriter.processAction(action)

        state = state.copy(
            expression = expressionWriter.expression
        )
    }

}