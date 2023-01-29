package com.example.calculatorapp.domain

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MOD('%');
}

fun operationFromSymbol(symbol: Char): Operation {
    return Operation.values().find { it.symbol == symbol } ?: throw IllegalArgumentException("Invalid symbol")
}

val operationValues = Operation.values().map { it.symbol }.joinToString()