package com.example.calculatorapp.presentation.ui.screen.calculator

import com.example.calculatorapp.domain.CalculatorAction

sealed class CalculatorEvent(
    val uiAction: CalculatorAction
)