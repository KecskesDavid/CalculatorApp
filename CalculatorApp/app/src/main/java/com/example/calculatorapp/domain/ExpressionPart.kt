package com.example.calculatorapp.domain

sealed interface ExpressionPart {
    data class Number(val number: Double): ExpressionPart
    data class Op(val operation: Operation?): ExpressionPart
    data class Parentheses(val isOpen: Boolean): ExpressionPart
}