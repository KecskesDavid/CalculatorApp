package com.example.calculatorapp.presentation.model

import com.example.calculatorapp.domain.CalculatorAction

data class CalculatorUiAction(
    val text: String? = null,
    val content: Int? = null,
    val level: CalculatorButtonLevel,
    val action: CalculatorAction,
)

sealed interface CalculatorButtonLevel {
    object Neutral : CalculatorButtonLevel
    object Primary : CalculatorButtonLevel
    data class Highlighted(val stronglyHighlighted: Boolean = false) : CalculatorButtonLevel
}