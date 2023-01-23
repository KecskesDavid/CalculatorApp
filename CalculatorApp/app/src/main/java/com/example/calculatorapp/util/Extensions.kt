package com.example.calculatorapp.util

import com.example.calculatorapp.domain.Operation
import com.example.calculatorapp.domain.operationValues

fun Char.isParenthesis() = this == ')' || this == '('

fun Char.isOperation() = operationValues.contains(this)