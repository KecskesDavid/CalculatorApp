package com.example.calculatorapp.presentation.model

import com.example.calculatorapp.R
import com.example.calculatorapp.domain.CalculatorAction
import com.example.calculatorapp.domain.Operation

val calculatorUiActions = listOf (
    // Grid row nr. 1
    CalculatorUiAction(
        text = "AC",
        level = CalculatorButtonLevel.Highlighted(stronglyHighlighted = true),
        action = CalculatorAction.Clear
    ),
    CalculatorUiAction(
        text = "()",
        level = CalculatorButtonLevel.Primary,
        action = CalculatorAction.Parentheses
    ),
    CalculatorUiAction(
        text = "%",
        level = CalculatorButtonLevel.Primary,
        action = CalculatorAction.Op(Operation.MOD)
    ),
    CalculatorUiAction(
        text = "/",
        level = CalculatorButtonLevel.Primary,
        action = CalculatorAction.Op(Operation.DIVIDE)
    ),

    // Grid row nr. 2
    CalculatorUiAction(
        text = "7",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(7)
    ),
    CalculatorUiAction(
        text = "8",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(8)
    ),
    CalculatorUiAction(
        text = "9",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(9)
    ),
    CalculatorUiAction(
        text = "X",
        level = CalculatorButtonLevel.Primary,
        action = CalculatorAction.Op(Operation.MULTIPLY)
    ),

    // Grid row nr. 3
    CalculatorUiAction(
        text = "4",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(4)
    ),
    CalculatorUiAction(
        text = "5",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(5)
    ),
    CalculatorUiAction(
        text = "6",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(6)
    ),
    CalculatorUiAction(
        text = "-",
        level = CalculatorButtonLevel.Primary,
        action = CalculatorAction.Op(Operation.SUBTRACT)
    ),

    // Grid row nr. 4
    CalculatorUiAction(
        text = "1",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(1)
    ),
    CalculatorUiAction(
        text = "2",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(2)
    ),
    CalculatorUiAction(
        text = "3",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(3)
    ),
    CalculatorUiAction(
        text = "+",
        level = CalculatorButtonLevel.Primary,
        action = CalculatorAction.Op(Operation.ADD)
    ),

    // Grid row nr. 5
    CalculatorUiAction(
        text = "0",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Number(0)
    ),
    CalculatorUiAction(
        text = ".",
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Decimal
    ),
    CalculatorUiAction(
        content = R.drawable.ic_delete,
        level = CalculatorButtonLevel.Neutral,
        action = CalculatorAction.Delete
    ),
    CalculatorUiAction(
        text = "=",
        level = CalculatorButtonLevel.Highlighted(),
        action = CalculatorAction.Calculate
    ),
)